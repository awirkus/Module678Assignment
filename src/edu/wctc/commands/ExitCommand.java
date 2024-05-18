package edu.wctc.commands;

import edu.wctc.Maze;

/**
 * This command returns the string provided when the user tries to exit the maze from their current room.
 *
 * */

public class ExitCommand implements ReturningCommand<String> {
    private Maze maze;

    public ExitCommand(Maze maze) {
        this.maze = maze;
    }

    @Override
    public String execute() {
        return maze.exitCurrentRoom();
    }
}
