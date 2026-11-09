# Pegmancer

A plinko-style roguelike. Drop balls through a board of pegs, score **points × mult × bucket**, and beat each round's target before you run out of drops. Spend gold between rounds on relics and board upgrades to build a combo that keeps up with the rising targets.

## Features

- 36 relics (common, uncommon and rare) that change scoring, physics, gold and the shop.
- 10 board upgrades: sharpen pegs, add red, gold, bumper, splitter, crit and bomb pegs, bigger outer buckets, extra drops.
- 7 peg types and 7 buckets with different multipliers.
- A boss round every 4th round, with a twist such as heavy gravity, tight buckets or a blackout.
- Shop rerolls, selling relics, interest on saved gold.
- **Run summary export**: copy or share a summary of a run (every drop, round, purchase and the final build) so you can send it in for balance changes.
- **Update** button on the title screen. The app also checks GitHub when it starts and downloads a new version only if you say yes.

## Install

Download the latest `Pegmancer-*.apk` from [Releases](../../releases/latest) on your phone and open it. Android will ask you to allow installs from your browser the first time.

Every push to `main` builds a new signed APK with GitHub Actions and publishes it as a release.

The whole game is one file, `app/src/main/assets/index.html`. It also runs in a desktop browser.

## Support

If you find this useful, you can support my work through [GitHub Sponsors](https://github.com/sponsors/kefirman9000). Thank you!
