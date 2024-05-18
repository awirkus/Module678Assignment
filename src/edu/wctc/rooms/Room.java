package edu.wctc.rooms;

import edu.wctc.Player;

/**
 * The Room class, and its related interfaces/classes, were made to follow the Strategy Design Pattern.
 * The common attributes and actions to all rooms as they would relate to this program are all wrapped up in this
 * abstract class.
 * Unique and/or repeated actions for more specific room types that won't necessarily be available to some room types
 * were separated out into Interfaces to allow for concrete instances of Room objects to be more modular.
 * For instance, the InteractAndLoot and AllActionable are used to encapsulate different strategies for defining room
 * behaviors, as implemented in the EastRoom and ExitRoom classes.
 *
 * */

public abstract class Room {
    private String name;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room up;  // Not used currently
    private Room down;  // Not used currently



    public Room(String name) {
        this.name = name;
    }

    public abstract String getDescription(Player player);

    public String getExits() {
        String exitsString = "Available Doors: ";

        if (north != null) {
            exitsString = exitsString + "North ";
        }
        if (south != null) {
            exitsString = exitsString + "South ";
        }
        if (east != null) {
            exitsString = exitsString + "East ";
        }
        if (west != null) {
            exitsString = exitsString + "West ";
        }

        return exitsString;
    };

    public String getName() {
        return name;
    };

    @Override
    public String toString() {
        return "You are currently in " + name;
    }

    public boolean isValidDirection(char direction) {
        if (Character.toLowerCase(direction) == 'n')
            return north != null;
        else if (Character.toLowerCase(direction) == 's')
            return south != null;
        else if (Character.toLowerCase(direction) == 'e')
            return east != null;
        else if (Character.toLowerCase(direction) == 'w')
            return west != null;
        else if (Character.toLowerCase(direction) == 'u')  // Not used
            return up != null;
        else if (Character.toLowerCase(direction) == 'd')  // Not used
            return down != null;

        return false;
    };

    public Room getAdjoiningRoom(char direction) {
        if (Character.toLowerCase(direction) == 'n')
            return north;
        else if (Character.toLowerCase(direction) == 's')
            return south;
        else if (Character.toLowerCase(direction) == 'e')
            return east;
        else if (Character.toLowerCase(direction) == 'w')
            return west;
        else if (Character.toLowerCase(direction) == 'u')  // Not used
            return up;
        else if (Character.toLowerCase(direction) == 'd')  // Not used
            return down;

        return null;
    };

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {  // Not used
        this.up = up;
    }

    public void setDown(Room down) {  // Not used
        this.down = down;
    }
}
