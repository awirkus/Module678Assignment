package edu.wctc.commands;

import edu.wctc.Maze;

/**
 * This command returns the string provided when the user wants to see the contents of their inventory.
 *
 * */

public class ShowInventoryCommand implements ReturningCommand<String> {
    private Maze maze;

    public ShowInventoryCommand(Maze maze) {
        this.maze = maze;
    }

    @Override
    public String execute() {
        return maze.getPlayerInventory();
    }
}
