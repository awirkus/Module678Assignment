package edu.wctc.commands;

import edu.wctc.Maze;

/**
 * This command returns the string provided when the user wants to see their current room's description again.
 *
 * */

public class RoomDescriptionCommand implements ReturningCommand<String> {
    private Maze maze;

    public RoomDescriptionCommand(Maze maze) {
        this.maze = maze;
    }

    @Override
    public String execute() {
        String roomDescription;
        roomDescription = "\n" + maze.getCurrentRoomName() +
                "\n\n" + maze.getCurrentRoomDescription() +
                "\n" + maze.getCurrentRoomExits();

        return roomDescription;
    }
}
