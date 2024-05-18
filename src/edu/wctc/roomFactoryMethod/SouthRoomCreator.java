package edu.wctc.roomFactoryMethod;

import edu.wctc.rooms.*;

/**
 * This class was made to provide a factory method for creating a South room.
 *
 * */

public class SouthRoomCreator extends RoomCreator {
    @Override
    public Room createRoom(String name) {
        return new SouthRoom(name);
    }
}
