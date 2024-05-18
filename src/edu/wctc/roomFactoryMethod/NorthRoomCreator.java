package edu.wctc.roomFactoryMethod;

import edu.wctc.rooms.*;

/**
 * This class was made to provide a factory method for creating a North/Exit room.
 *
 * */

public class NorthRoomCreator extends RoomCreator {
    @Override
    public Room createRoom(String name) {
        return new ExitRoom(name);
    }
}
