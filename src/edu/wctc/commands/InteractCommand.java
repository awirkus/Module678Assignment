package edu.wctc.commands;

import edu.wctc.Maze;

/**
 * This command returns the string provided when the user tries to interact with their current room.
 *
 * */

public class InteractCommand implements ReturningCommand<String> {
    private Maze maze;

    public InteractCommand(Maze maze) {
        this.maze = maze;
    }

    @Override
    public String execute() {
        return maze.interactWithCurrentRoom();
    }
}
