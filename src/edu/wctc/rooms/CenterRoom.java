package edu.wctc.rooms;

import edu.wctc.Player;

import static edu.wctc.ItemType.*;

/**
 * This is a concrete room class that represents the Center room in the maze game.
 *
 * */

public class CenterRoom extends Room implements InteractAndLoot {
    private boolean isBackhoeLocked = true;

    public CenterRoom(String name) {
        super(name);
    }

    @Override
    public String interact(Player player) {
        if (player.doesInventoryContain(CROWBAR) && isBackhoeLocked) {
            isBackhoeLocked = false;
            player.addToScore(100);
            return "You use the CROWBAR on the door to the backhoe. It took some considerable effort, but it opened up!\n";
        } else if (!player.doesInventoryContain(SHOVEL) && !isBackhoeLocked) {
            return "The backhoe door is now open thanks to a little help from your trusty Crowbar! There is something\n" +
                    "inside that might be useful somewhere else.";
        } else if (player.doesInventoryContain(SHOVEL) && !isBackhoeLocked) {
            return "Nothing happened. There is nothing else to do here.\n";
        }

        return "You cannot interact with this room without the proper tool.\n";
    }


    @Override
    public String loot(Player player) {
        if (player.doesInventoryContain(SHOVEL)) {
            return "You have already looted this room.\n";
        }

        if (!isBackhoeLocked) {
            player.addToInventory(SHOVEL);
            player.addToScore(50);
            return "You found a SHOVEL! It was added to your inventory.\n";
        } else if (isBackhoeLocked) {
            return "You cannot loot this room at this time. Perhaps you could find something by using the right tool.\n";
        }
        return "You cannot loot this room.\n";
    }

    @Override
    public String getDescription(Player player) {
        if (player.doesInventoryContain(SHOVEL) && !isBackhoeLocked) {
            return "Here is the room with the concrete mixer, wheelbarrow, and backhoe. The backhoe\n" +
                    "has been opened and is empty.";
        } else if (!player.doesInventoryContain(SHOVEL) && !isBackhoeLocked) {
            return "Here is the room with the concrete mixer, wheelbarrow, and backhoe. The backhoe\n" +
                    "has been opened and you see something inside.";
        }

        return "In this room you see a concrete mixer, a wheelbarrow, and off to the side a backhoe\n" +
                "pressed against the wall uncomfortably. Looking inside the cabinet of the backhoe, you\n" +
                "see a shovel. One of the cabinet doors is pressed too close to the wall for you to open.\n" +
                "The other door appears to have been dented shut.";
    }
}
