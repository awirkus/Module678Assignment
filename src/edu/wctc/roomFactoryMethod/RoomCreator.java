package edu.wctc.roomFactoryMethod;

import edu.wctc.rooms.*;

/**
 * This class was created in order to implement the Factory Method Design Pattern.
 * The sole purpose of this class and its subclasses is to create and return new concrete Room objects when called.
 * This allows for flexible creation of Room objects whenever that might be needed.
 *
 * */

public abstract class RoomCreator {
    public abstract Room createRoom(String name);
}
