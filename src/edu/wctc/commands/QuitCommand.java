package edu.wctc.commands;

import edu.wctc.Maze;

/**
 * This command returns the string provided when the user tries to quit the game.
 *
 * */

public class QuitCommand implements ReturningCommand<String> {
    private Maze maze;

    public QuitCommand(Maze maze) {
        this.maze = maze;
    }

    @Override
    public String execute() {
        maze.setIsFinished(true);
        return "Thanks for playing! You scored " + maze.getPlayerScore() + " points.";
    }
}
