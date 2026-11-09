package com.kefirman9000.pegmancer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Insets;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MainActivity extends Activity {
    private static final String REPO = "kefirman9000/pegmancer";
    private static final String BASE = "https://pegmancer.local/";
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#130F26"));
        web = new WebView(this);
        web.setBackgroundColor(Color.parseColor("#130F26"));
        root.addView(web, new FrameLayout.LayoutParams(-1, -1));
        setContentView(root);

        // keep the game clear of the status bar, navigation bar and camera cutout
        root.setOnApplyWindowInsetsListener((v, insets) -> {
            Insets i = insets.getInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
            v.setPadding(i.left, i.top, i.right, i.bottom);
            return WindowInsets.CONSUMED;
        });

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        web.addJavascriptInterface(new Bridge(), "PegmancerApp");
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest req) {
                Uri u = req.getUrl();
                if (u.toString().startsWith(BASE)) return false;
                try { startActivity(new Intent(Intent.ACTION_VIEW, u)); } catch (Exception ignored) {}
                return true;
            }
        });

        if (savedInstanceState != null) web.restoreState(savedInstanceState);
        else web.loadDataWithBaseURL(BASE, wrapPage(), "text/html", "utf-8", null);

        web.postDelayed(() -> checkForUpdate(false), 2000);
    }

    // index.html is written without <html>/<head>/<body>, so add them here
    private String wrapPage() {
        String body = "";
        try (InputStream in = getAssets().open("index.html")) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) > 0) out.write(buf, 0, n);
            body = out.toString(StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            body = "<p style='color:#fff'>Could not load the game: " + e.getMessage() + "</p>";
        }
        return "<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no,viewport-fit=cover\">"
                + "<style>body{margin:0;font:14px system-ui,sans-serif}[hidden]{display:none!important}img{max-width:100%}</style>"
                + "</head><body>" + body + "</body></html>";
    }

    @Override
    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        web.saveState(out);
    }

    @Override
    public void onBackPressed() {
        web.evaluateJavascript("window.pegmancerBack && window.pegmancerBack()", r -> {
            if (!"true".equals(r)) MainActivity.super.onBackPressed();
        });
    }

    private String versionName() {
        try { return getPackageManager().getPackageInfo(getPackageName(), 0).versionName; }
        catch (Exception e) { return "?"; }
    }

    class Bridge {
        @JavascriptInterface public String version() { return versionName(); }

        @JavascriptInterface public void copy(String text) {
            runOnUiThread(() -> {
                ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                cm.setPrimaryClip(ClipData.newPlainText("Pegmancer run summary", text));
                toast("Copied run summary");
            });
        }

        @JavascriptInterface public void share(String text) {
            runOnUiThread(() -> {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Pegmancer run summary");
                i.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(i, "Send run summary"));
            });
        }

        @JavascriptInterface public void checkUpdate() { runOnUiThread(() -> checkForUpdate(true)); }
    }

    // ---------- updater: asks first, downloads only if you say yes ----------

    private void checkForUpdate(boolean manual) {
        if (manual) toast("Checking for updates…");
        new Thread(() -> {
            try {
                HttpURLConnection c = (HttpURLConnection) new URL("https://api.github.com/repos/" + REPO + "/releases/latest").openConnection();
                c.setRequestProperty("Accept", "application/vnd.github+json");
                c.setConnectTimeout(8000);
                c.setReadTimeout(8000);
                int code = c.getResponseCode();
                if (code != 200) throw new Exception("GitHub answered " + code);
                StringBuilder sb = new StringBuilder();
                try (BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()))) {
                    String line;
                    while ((line = r.readLine()) != null) sb.append(line);
                }
                JSONObject j = new JSONObject(sb.toString());
                String tag = j.getString("tag_name");
                int remote = Integer.parseInt(tag.substring(tag.lastIndexOf('.') + 1).replaceAll("\\D", ""));
                String apk = null;
                JSONArray assets = j.optJSONArray("assets");
                if (assets != null) {
                    for (int k = 0; k < assets.length(); k++) {
                        JSONObject a = assets.getJSONObject(k);
                        if (a.optString("name").endsWith(".apk")) { apk = a.getString("browser_download_url"); break; }
                    }
                }
                long local = getPackageManager().getPackageInfo(getPackageName(), 0).getLongVersionCode();
                final String apkUrl = apk;
                final String localName = versionName();
                runOnUiThread(() -> {
                    if (remote > local && apkUrl != null) {
                        new AlertDialog.Builder(this)
                                .setTitle("Update available")
                                .setMessage("Pegmancer " + tag.replaceFirst("^v", "") + " is out (you have " + localName + ").\n\n"
                                        + "Download it now? Your browser will download the APK. Open it to install. Your best scores are kept.")
                                .setPositiveButton("Download", (dlg, w) ->
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(apkUrl))))
                                .setNegativeButton("Not now", null)
                                .show();
                    } else if (manual) {
                        toast("You have the latest version (" + localName + ")");
                    }
                });
            } catch (Exception e) {
                if (manual) runOnUiThread(() -> toast("Couldn't check for updates: " + e.getMessage()));
            }
        }).start();
    }

    private void toast(String s) { Toast.makeText(this, s, Toast.LENGTH_SHORT).show(); }
}
