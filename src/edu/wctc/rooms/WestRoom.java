package edu.wctc.rooms;

import edu.wctc.Player;

import static edu.wctc.ItemType.*;

/**
 * This is a concrete room class that represents the West room in the maze game.
 *
 * */

public class WestRoom extends Room implements Lootable {
    private boolean haveReminisced = false;

    public WestRoom(String name) {
        super(name);
    }

    @Override
    public String loot(Player player) {
        if (player.doesInventoryContain(CROWBAR)) {
            return "You have already looted this room.\n";
        }
        player.addToInventory(CROWBAR);
        player.addToScore(50);
        return "You found the CROWBAR! It was added to your inventory.\n";
    }

    @Override
    public String getDescription(Player player) {
        if (player.doesInventoryContain(CROWBAR) && !haveReminisced) {
            haveReminisced = true;
            return "Just a bunch of scrap. You reminisce about the time that you found your trusty crowbar.\n" +
                    "Giving it another once over, you happen to notice what looks like someone's name written\n" +
                    "in what was meant to be permanent marker, but most of it had been thoroughly worn off. All\n" +
                    "you could make out was, 'G...on P..e..n.' Though, that 'G' might be a 'B' and that 'P' might\n" +
                    "be an 'F' ... It's difficult to tell.";
        } else if (haveReminisced) {
            return "A room filled with mostly useless junk. Someone left that awesome crowbar that you took\n" +
                    "earlier. I bet they sure do miss it...";
        }

        return "This room contains a cornucopia of scrap and mostly empty supply crates. As you look around\n" +
                "the room, most of what’s there is useless. Still, you think you might be able to find \n" +
                "something useful.";
    }
}