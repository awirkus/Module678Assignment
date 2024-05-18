package edu.wctc.roomFactoryMethod;

import edu.wctc.rooms.*;

/**
 * This class was made to provide a factory method for creating a Center room.
 *
 * */

public class CenterRoomCreator extends RoomCreator {
    @Override
    public Room createRoom(String name) {
        return new CenterRoom(name);
    }
}
