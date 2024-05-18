package edu.wctc.rooms;

import edu.wctc.Player;

import static edu.wctc.ItemType.*;

/**
 * This is a concrete room class that represents the North room in the maze game.
 *
 * */

public class ExitRoom extends Room implements AllActionable {

    public ExitRoom(String name) {
        super(name);
    }
    public boolean spiderIsDead = false;

    public boolean isSpiderDead() {
        return spiderIsDead;
    }

    @Override
    public String interact(Player player) {
        if (player.doesInventoryContain(BUG_BOMB) && !spiderIsDead) {
            spiderIsDead = true;
            player.addToScore(200);
            return "You pull the pin on the BUG BOMB and lob it as close to the spider as you can\n" +
                    "without rousing it. You cover your face and brace yourself just as it goes off.\n" +
                    "A billowing cloud forms beneath the spider. The spider begins to writhe as it is\n" +
                    "enveloped by the gas. After a few short moments, the spider falls to the ground,\n" +
                    "legs up, before ceasing to move. Just to be safe, once the gas dissipates, you\n" +
                    "throw a rock at it to see if it will stir. It does not! Safe to say, the spider\n" +
                    "will no longer be bothering you. The way out is now clear!\n";
        } else if ((player.doesInventoryContain(CROWBAR) || player.doesInventoryContain(SHOVEL)) && !spiderIsDead) {
            return "Nothing you have will be effective against the spider. It is too big for a brute force\n" +
                    "effort. You need to find something that makes up for the size difference.";
        } else if (spiderIsDead) {
            return "The spider is no longer a threat. You may now exit the maze.\n";
        }

        return "You cannot interact with this room without the proper tool.\n";
    }

    @Override
    public String loot(Player player) {
        if (player.doesInventoryContain(FANG)) {
            return "You have already looted this room.\n";
        }

        if (spiderIsDead) {
            player.addToInventory(FANG);
            player.addToScore(300);
            return "You took one of the spider's FANGs! It was added to your inventory.\n";
        } else if (!spiderIsDead) {
            return "You cannot loot this room at this time.\n";
        }
        return "You cannot loot this room.\n";
    }

    @Override
    public String exit(Player player) {
        player.addToScore(1000);
        return "Congratulations! You have successfully completed the maze!\nYou scored " + player.getScore() + " points.\n";
    }

    @Override
    public String getDescription(Player player) {
        if (spiderIsDead) {
            return "The spider has been taken care of. Your way out is clear!";
        } else if (player.doesInventoryContain(BUG_BOMB) && !spiderIsDead) {
            return "The giant spider still hangs motionless above what seems to be your only escape. Hopefully\n" +
                    "your diligent exploration of this abandoned construction site will pay off. You think that\n" +
                    "you might have found something that could get you out of here without further harm.";
        }

        return "As you enter this room, you see a door on the other end labeled 'EXIT' and realize that this\n" +
                "is your way out. However, hanging very still over the door is a spider about the size of a car.\n" +
                "Fear paralyzes you for a moment before you notice a door to the outside just behind the spider.\n" +
                "You don’t dare approach the door while the spider is still there. It seems content for now, but\n" +
                "you don’t want to tempt its appetite.";
    }
}
