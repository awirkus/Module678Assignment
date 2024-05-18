package edu.wctc.rooms;

import edu.wctc.Player;

import static edu.wctc.ItemType.*;

/**
 * This is a concrete room class that represents the South room in the maze game.
 *
 * */

public class SouthRoom extends Room implements InteractAndLoot {
    private boolean dirtIsDug = false;

    public SouthRoom(String name) {
        super(name);
    }

    @Override
    public String interact(Player player) {
        if (player.doesInventoryContain(SHOVEL) && !dirtIsDug) {
            dirtIsDug = true;
            player.addToScore(100);
            return "You use the SHOVEL to remove the pile of loose dirt that you found. After a few\n" +
                    "minutes of digging, you notice something shiny popping out of the dirt.\n";
        } else if (!player.doesInventoryContain(KEY) && dirtIsDug) {
            return "Nothing happened. You already dug up the dirt and see something that you could take.\n";
        } else if (player.doesInventoryContain(KEY) && dirtIsDug) {
            return "Nothing happened. The dirt pile has already been dug up and there is nothing else\n" +
                    "to be found.";
        }
        return "You cannot interact with this room without the proper tool.\n";
    }

    @Override
    public String loot(Player player) {
        if (player.doesInventoryContain(KEY)) {
            return "You have already looted this room.\n";
        }

        if (dirtIsDug) {
            player.addToInventory(KEY);
            player.addToScore(50);
            return "You found a KEY! It was added to your inventory.\n";
        } else if (!dirtIsDug) {
            return "You cannot loot this room at this time. Perhaps you could find something by using the right tool.\n";
        }
        return "You cannot loot this room.\n";
    }

    @Override
    public String getDescription(Player player) {
        if (player.doesInventoryContain(KEY) && dirtIsDug) {
            return "Just an empty room where you dug a hole.";
        } else if (!player.doesInventoryContain(KEY) && dirtIsDug) {
            return "Just an empty room with a freshly dug hole. Maybe there's something in there\n" +
                    "that you could take.";
        }
        return "Your initial reaction when you enter this room is disappointment. There seems to be\n" +
                "nothing there. Upon closer inspection, however, you notice a small patch of looser,\n" +
                "darker dirt in the corner.";
    }
}