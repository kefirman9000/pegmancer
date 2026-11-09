# Pegmancer

A darkly comic plinko roguelike. You are a junior demon launching damned souls down the Boards of Torment. Torment pegs give their value in suffering, then halve and pop. Overshoot quota and fresh consignments of the damned arrive, fusing into greater sinners. Build absurd combos from triggered relics before the Infernal Auditor unmakes you.

## Features

- **Soul cannon**: on PC the cannon follows the mouse; click to fire. On phones, drag on the board to aim, then tap **Launch**. A dotted line shows the path to the first peg. Hold the click or the Launch button to charge one Hellfire soul per round.
- **Torment pegs** worth powers of 2. Each hit scores the value, then halves it. At 0 the peg pops. Purge the board for ×2.
- **Consignments**: every time your round total passes quota again, empty slots refill and matching neighbours merge. Each one pays a coin.
- **Suffering × mult × bucket** scoring, with sigil pegs for mult, coins, bounce, splits, crits and blasts.
- **47 relics** with triggers (on hit, on pop, every N pops, on wall, on landing, on quota, on consignment…) that fire left to right. Slot order matters, including the Amplifier and Mirror. Duplicates level up to ×3. Temporary relics burn out after a few rounds.
- **Up to 7 relic shelves**, plus 12 Binding Oaths that force-trigger relics, and single-use snacks.
- **Infernal Commissary** (freeze, reroll, board upgrades, extra shelves), **Brimstone Canteen**, **Soul Lottery** claw machine, and the **Black Ledger** of cursed contracts (needs a Ledger Key).
- 60 rounds across four Departments of Hell, audits every 5 rounds, and a boss every 20 who sabotages your board. The next audit or boss is announced a round ahead, with a tip for countering it. Endless mode after that.
- **Board remodels**: every 5 rounds the board changes shape (The Slant, The Chasm, The Funnel, Twin Pits). Your pegs keep their values.
- **Combo callouts**: after each launch, the score card names the relics that fired most, including Amplifier and Mirror chains.
- **Run summary export**: copy or share a full log of the run (every launch, round, purchase and the final build) to send in for balance changes.
- **Check for updates** on the title screen. The app also checks GitHub at launch and downloads a new version only if you say yes.

## Install

Download the latest `Pegmancer-*.apk` from [Releases](../../releases/latest) on your phone and open it. Android will ask you to allow installs from your browser the first time.

Every push to `main` builds a new signed APK with GitHub Actions and publishes it as a release.

The whole game is one file, `app/src/main/assets/index.html`. It also runs in a desktop browser.

## Support

If you find this useful, you can support my work through [GitHub Sponsors](https://github.com/sponsors/kefirman9000). Thank you!

### More chaos
- **Multi-peg relics**: Chain Lightning arcs to nearby pegs, Kindred Torment hits every peg sharing a value, Twin Strike and Bone Shrapnel hit neighbours.
- **Timer relics**: Bugle of Torment and Screaming Gargoyle fire on a clock while a soul falls; Oath of Chaos triggers a random relic every second.
- **Peg copying**: Usurper's Crown and Mimic Chest copy big values onto small pegs.
- **Gambling snacks**: Devil's Wager (double or nothing), Chaos Stew (reroll all relics), Sacrificial Offering (upgrade right, destroy left).
- **Overkill pay**: beating quota by 2×, 4×, 8×… pays extra coins.
- **Contracts**: earn hellmarks from runs and unlock starting contracts (Glass, Gambler's, Hoarder's, Arsonist's, Probation).
- **Board scramble**, **daily seeded run**, and a final boss at round 60.
- **Relic evolutions**: hold two matching relics at ×3 and they fuse into an evolved relic at the start of the next round (e.g. Ember + Snowball's Chance → Inferno Snowball). Seven recipes.
- **Jackpots**: landing in a ×4 bucket rains coins, with a small chance of a free relic.
- **Relic Book**: every relic you've seen, owned and won with, plus your records.
- **Save and resume**: a run is saved after every launch; Continue picks it up from the title screen.
- **Peg tiers**: every power of 2 has its own colour and shape; 1-pegs are ghosts the soul passes straight through.
- **More sigils**: Chain (hits the 3 nearest pegs), Gluttony (doubles 2 neighbours), Warp (sends the soul back to the top).
- **Summons**: Brimstone Meteor, Imp Swarm and Judgment Hammer drop things onto the board.
- Meeting quota restores a chance; the Hiring Freeze audit disables your two leftmost relics.
- **Chain reactions**: hits and pops made by relics can trigger more relics, link after link (Lit Fuse, Domino Damnation, Powder Keg, Oath of Cascade, and the Chain of Ruin evolution are built for it).
