package edu.wctc.roomFactoryMethod;

import edu.wctc.rooms.*;

/**
 * This class was made to provide a factory method for creating an East room.
 *
 * */

public class EastRoomCreator extends RoomCreator {
    @Override
    public Room createRoom(String name) {
        return new EastRoom(name);
    }
}
