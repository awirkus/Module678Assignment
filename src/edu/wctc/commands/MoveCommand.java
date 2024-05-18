package edu.wctc.commands;

import edu.wctc.Maze;

/**
 * This command returns the string provided when the user tries to move to an adjacent room.
 *
 * */

public class MoveCommand implements ReturningCommand<String> {
    private Maze maze;
    private String direction;

    public MoveCommand(Maze maze, String direction) {
        this.maze = maze;
        this.direction = direction;
    }

    @Override
    public String execute() {
        if (!maze.move(direction.charAt(0))) {
            return  "Invalid direction. Try again.\n";
        } else {
            return "\n" + maze.getCurrentRoomName() +
                    "\n\n" + maze.getCurrentRoomDescription() +
                    "\n" + maze.getCurrentRoomExits();
        }
    }
}
