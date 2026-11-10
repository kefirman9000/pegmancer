# Pegmancer

A darkly comic plinko roguelike. You are a junior demon launching damned souls down the Boards of Torment. Torment pegs give their value in suffering, then halve and pop. Overshoot quota and fresh consignments of the damned arrive, fusing into greater sinners. Build absurd combos from triggered relics before the Infernal Auditor unmakes you.

## Features

- **Soul cannon**: on PC the cannon follows the mouse; click to fire. On phones, swipe sideways on the board to swing the cannon (faster swipes turn it further; aim speed is adjustable on the title screen), then tap the board (or **Launch**) to fire. A dotted line shows the path to the first peg. Hold the click or the Launch button to charge one Hellfire soul per round.
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
- **More relics**: Rebound Imp, Infernal Furnace, Shrieking Harpy, Frost Tithe, Perfect Sin, Undying Grub, Collector's Claw, Hollow Reliquary, Doomsday Skull, Toadstool of Madness, Bloated Idol, Puppet of Penance, Relay Totem, Star-Spawn; cursed Serpent's Gamble; snacks Blood Berry and Hellhound Dog.
- **Relic tiles**: relics sit in a row of tiles above the board; lasers, zaps and summoned souls come out of the tile that fired them (Hellgaze Laser, Soul Spout, Branding Iron and more).

### Hells
Each 20-round department is its own hell with a palette, animated backdrop, sounds, music and a house rule. You start in the Intake Office (Paperwork), pick one of two doors after the round-20 and round-40 bosses, and end in The Abyss (Gravity well). Door hells: Lava Works (Magma tide), Bone Archive (Ossuary), Frozen Treachery (Black ice), Gluttony's Kitchen (Simmer), Hall of Mirrors (Reflection), Storm of Lust (Gale), Eternal Library (Re-reading). Each hell stocks two relics you can't find anywhere else. Boss rounds put a face behind the board, and the room glows when you're far over quota.
- **Buckets**: landings look and sound different by multiplier (a dud puffs, ×1.5 rings, ×2 flares, ×4 erupts with gold rays), buckets match the hell you're in, and six bucket enchantments can be bought as board upgrades: Furnace (erupts up its column), Tithe (pays coins), Spring (flings the soul back up), Fattening (grows +0.25 per landing, permanently), Crimson (adds its value to mult), Spawning (releases 2 souls). Bucket relics: Bucket Brigade, Hellmouth, Brimstone Geyser, Payout Chute, Trampoline of Torment, Rising Stakes.

### Threats and variety
- **Imps** hop between pegs and halve them during and after launches; hit one with a soul to slay it for coins.
- **Bosses** stand on the board with a health bar. Drain it with soul hits and pops, and make quota, to win. Each launch they shield, smash pegs or grow thorns. Scraping past a boss under 1.5× quota adds a curse.
- **The Auditor's patience** (bar at the top) fills on weak launches; when it runs out a relic is confiscated, the top row is set to 1, or a cursed relic is forced on you.
- **Missing quota** also freezes a relic for 3 rounds or adds a run-long curse (Leaden Souls, Rusted Buckets, Usury, Briar Curse, Infestation, Drought).
- **Peg types**: armored, glass (×4 then shatters), ticking (explodes after 3 launches), rot (spreads), chests, greed gems (double each launch you leave them, then crumble), portals; hazards by hell: thorns, red tape, rot.
- **Every round** can roll a board event (Gold rush, Sliding rows, Whirlpool, Heavy/Feather souls, High society, Fog, Portals, Unstable board, Glassworks, Ironworks, Open bar) and offers a bounty with a reward.
- **Layouts**: The Spiral, The Cage (a chest in the middle), The Wall (one gap), The Tunnel join the remodel rotation.
- Threats act once per round: imps mark the peg they want and the boss shows its move; both act after your first launch. Ticking pegs and rot advance once per round. Nothing happens while you're idle.
- **Multiply/halve relics**: Tripling Forge, Abyssal Square, Cleaver of Halves, The Leveller, Robin of the Pit, Damned Coin, Hyperinflation, Mitosis.
- **Halving relics**: a new "a peg is halved" trigger fires on every halving, including ones imps and bosses cause: Silver Lining, Splinter Shards, Karmic Debt, Halving Refund, Phoenix Ash, Hollow Echo.
- **Numbers keep growing**: at the start of every round, the peg floor rises to last round's biggest peg (rounded down to a power of 2). Every peg below it is raised to it, and new pegs spawn at it or higher.
- **Launch and end-of-round pieces**: relics Volley of the Damned, Last Call, Opening Act, Wind-Up (on launch) and Closing Bell, Leftover Souls, Grim Accountant, Harvest Moon, Safety Net (at the end of the round); oaths of the Kickoff, the Finale, the Salvo, Closing Time and Reckoning.
