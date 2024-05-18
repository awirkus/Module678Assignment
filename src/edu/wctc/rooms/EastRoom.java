package edu.wctc.rooms;

import edu.wctc.Player;

import static edu.wctc.ItemType.*;

/**
 * This is a concrete room class that represents the East room in the maze game.
 *
 * */

public class EastRoom extends Room implements InteractAndLoot {
    private boolean isCabinetLocked = true;

    public EastRoom(String name) {
        super(name);
    }

    @Override
    public String interact(Player player) {
        if (player.doesInventoryContain(KEY) && isCabinetLocked) {
            isCabinetLocked = false;
            player.addToScore(100);
            return "You use the KEY on the cabinet. Inside you find many supplies, including a healthy\n" +
                    "supply of industrial grade pesticides.\n";
        } else if (!player.doesInventoryContain(BUG_BOMB) && !isCabinetLocked) {
            return "Nothing happened. The cabinet has already been open. You see something you could take.\n";
        } else if (player.doesInventoryContain(BUG_BOMB) && !isCabinetLocked) {
            return "Nothing happened. The cabinet is open and nothing else inside of it would be useful.\n";
        }
        return "You cannot interact with this room without the proper tool.\n";
    }

    @Override
    public String loot(Player player) {

        if (player.doesInventoryContain(BUG_BOMB)) {
            return "You have already looted this room.\n";
        }

        if (!isCabinetLocked) {
            player.addToInventory(BUG_BOMB);
            player.addToScore(50);
            return "You found a BUG_BOMB! It was added to your inventory.\n";
        } else if (isCabinetLocked) {
            return "You cannot loot this room at this time. Perhaps you could find something by using the right tool.\n";
        }
        return "You cannot loot this room.\n";
    }

    @Override
    public String getDescription(Player player) {
        if (!player.doesInventoryContain(BUG_BOMB) && !isCabinetLocked) {
            return "This is the room with the opened cabinet. You see something inside that could come in handy.";
        } else if (player.doesInventoryContain(BUG_BOMB) && !isCabinetLocked) {
            return "This is the room where you opened the cabinet.";
        }
        return "Here you find yourself in a room with mostly debris. However, there is a cabinet on\n" +
                "the far end of the room. You attempt to open it outright, but it is locked and\n" +
                "requires a key to open.";
    }
}
