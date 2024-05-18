package edu.wctc.rooms;

import edu.wctc.Player;

/**
 * This is an interface made for rooms that the player can loot in the maze game.
 *
 * */

public interface Lootable {
    String loot(Player player);
}
