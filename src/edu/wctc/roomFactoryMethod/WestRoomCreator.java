package edu.wctc.roomFactoryMethod;

import edu.wctc.rooms.*;

/**
 * This class was made to provide a factory method for creating a West room.
 *
 * */

public class WestRoomCreator extends RoomCreator {
    @Override
    public Room createRoom(String name) {
        return new WestRoom(name);
    }
}
