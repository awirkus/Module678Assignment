package edu.wctc.commands;

import edu.wctc.Maze;

/**
 * This command returns the string provided when the user tries to loot their current room.
 *
 * */

public class LootCommand implements ReturningCommand<String> {
    private Maze maze;

    public LootCommand(Maze maze) {
        this.maze = maze;
    }

    @Override
    public String execute() {
        return maze.lootCurrentRoom();
    }
}
