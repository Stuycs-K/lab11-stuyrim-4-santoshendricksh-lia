[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

:white_check_mark: Pyro Mage Attack

:white_check_mark: Hydro Sorceress Attack

:ballot_box_with_check:  Gaia's Archer Attack

:white_check_mark: Boss Attacks

:white_check_mark: Pyro Mage Special Attack

:white_check_mark: Hydro Sorceress Special Attack

:ballot_box_with_check: Gaia's Archer Special Attack

:white_check_mark: Boss Special Attack

:white_check_mark: Pyro Mage Self Support

:white_check_mark: Hydro Sorceress Self Support

:ballot_box_with_check:  Gaia's Archer Self Support

:white_check_mark: Boss Self Support

:white_check_mark: Pyro Mage Other Support

:white_check_mark: Hydro Sorceress Other Support

:ballot_box_with_check: Gaia's Archer Other Support

:white_check_mark: Terminal Correctly Displays the Info of Party Members and Enemies

:white_check_mark: Terminal Correctly Ends Game if User Quits, or if One Side is Defeated

:white_check_mark: Terminal Correctly Displays the Move Used

:ballot_box_with_check:  Terminal Changes Color of HP Depending on Percentage Remaining

:ballot_box_with_check:  Game Checks for Correct Input

:ballot_box_with_check: Status Effects (Burning, Poisoning, Buff, Debuff, DMG Amp, Paralysis) All Work

:ballot_box_with_check: Game Starts with a Random # of Adventurers








## Adventurer Subclasses

|  | Pyro Mage Adventurer (18 HP) | Hydro Sorceress Adventurer (30 HP) |
| :---: | :------: | :---------------:         |
| Brief Overview         | The Pyro Mage is a glass cannon that focuses on dishing out damage. He can apply a burn status effect or deal heavy damage in one shot.     | The Hydro Sorceress is a defensive unit that focuses on preserving her team and debuffing opponents for an easier win.                                             |
| Attack          | **Fireball Barrage**: The Pyro Mage launches a barrage of fireballs dealing **3-7 DMG** to one ENEMY. This move applies a burn effect that lasts *two turns*, dealing **2 DMG** each turn. The Pyro Mage acculumates **2 RAGE**.      | **Acid Waterfall**: The Hydro Sorceress summons a waterful that deals **2 DMG** to one ENEMY. This move reduces the ENEMY's DMG by **3 DMG** if they attack the next turn. The Hydro Sorceress accumulates **3 DEWDROPS**.       |
| Special Attack              | **Flame Pillar**: After the Pyro Mage has accumulated **9 RAGE**, he can call forth a flame pillar dealing **10 DMG** to one ENEMY. This flame pillar deals **3 DMG** to all other alive ENEMIES.    | **Drowning Vortex**: After the Hydro Sorceress has accumulated **8 DEWDROPS**, she can call forth a vortex that deals **6 DMG** to each ENEMY.  |
| Support (Self)               | **Blazing Empowerment**: The Pyro Mage accumulates **4 RAGE** and deals an extra **2 DMG** if he attacks the next round.      |  **Lake's Protection**: The Hydro Sorceress gains the blessing of the lake, healing herself for **1-2 HP** and increasing her **MAX HP** by **2 HP**.     |
| Support (Other)               | **Sunlight's Blessing**: The Pyro Mage grants one ALLY the blessing of the sun, boosting their damage by **2-3 DMG** if they attack the next round.      | **Ocean's Sacrifice**: The Hydro Sorceress loses **4 HP** to gift one ALLY with **2 HP** and **2 SPECIAL**.      |

## Extra Adventurer and Boss Subclasses

|  | Gaia's Archer Adventurer (24 HP) | Electro Spirit Boss (150 HP) |
| :---: | :------: | :---------------:         |
| Brief Overview         | Gaia's Archer is an all-rounder unit that can deal moderate damage, heal, or apply status effects to friends and foes alike randomly.     | The Electro Spirit is a boss that has an unpredictable fighting style. It focuses on whittling down the enemies' HP before calling a move that can instakill an enemy.                                              |
| Attack          | **Lethal Arrow**: Gaia's Archer shoots a random arrow dealing **2-5 DMG** to one ENEMY. This move is guaranteed to apply **ONE** of the status effects: **Paralysis**, **Burning**, **Poison**. Gaia's Archer accumulates **3 ENERGY**.      | **Thunder Pulse**: The Electro spirit sends forth a thunder pulse dealing **6 DMG** to one ENEMY and **4 DMG** to all other alive ENEMIES. This move has a **50%** chance to apply the burn status effect and a **25%** chance to apply the paralyzed effect to the selected ENEMY. The Electro Spirit gains **1 TAINTED PHOTON**.       |
| Special Attack              | **Arrow Barrage**: After the Pyro Mage has accumulated **10 ENERGY**, he can launch a barrage of arrows dealing **5 DMG** to all ENEMIES and applying **Paralysis**, **Burning**, and **Poison** to a select ENEMY.  | **Lightning's Roar**: After the Electro Spirit has accumulated **3 TAINTED PHOTONS**, it will select an alive ENEMY at random and have a **30%** chance to ***instantly kill*** that enemy.     |
| Support (Self)               | **Gift of Nature**: Gaia's Archer is bestowed with the Gift of Nature, which grants him **1-2 HP** per turn for *3 turns*.      | **Flash Forward**: The Lightning Spirit gains **1 TAINTED PHOTON** and either gains a random **DMG Buff** of **2-5 DMG** or a random **DMG Amp** of **1.5x-2.5x DMG**.
| Support (Other)               | **Sunlight's Afterglow**: Gaia's Archer's teammates feel the warmth of the sunlight's afterglow, gaining **1 HP** each and having all status effects, both beneficial and harmful, removed.      | **N/A**     |


