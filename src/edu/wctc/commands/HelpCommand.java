package edu.wctc.commands;

import edu.wctc.Maze;

/**
 * This command returns the string provided when the user asks to see the action help menu.
 *
 * */

public class HelpCommand implements ReturningCommand<String> {
    private Maze maze;

    public HelpCommand(Maze maze) {
        this.maze = maze;
    }

    @Override
    public String execute() {
        return maze.actionInfoMenu();
    }
}
