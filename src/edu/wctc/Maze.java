package edu.wctc;

import edu.wctc.roomFactoryMethod.*;
import edu.wctc.rooms.*;

/**
 * This class builds and operates the Maze that users must navigate through in the game.
 * It was made to implement the Singleton Design Pattern.
 * The Maze object is instantiated at declaration as a private static final object.
 * This makes the Maze self-contained inside the class itself without the ability to create another instance.
 * Doing this will protect the data contained inside the Maze object and ensures that when only one of an object should
 * exist at a time, that there is only one.
 *
 * */

public class Maze {
    private Player player;
    private Room currentRoom;
    private RoomCreator roomFactory;
    private boolean isFinished = false;

    private static final Maze maze = new Maze();

    private Maze() {
        this.player = new Player();
        constructionSiteMazeBuilder();
    }

    public static Maze getMaze() {
        return maze;
    }

    private void constructionSiteMazeBuilder() {
        this.roomFactory = new CenterRoomCreator();
        Room centerRoom = roomFactory.createRoom("THE ARENA");
        this.roomFactory = new EastRoomCreator();
        Room eastRoom = roomFactory.createRoom("HOME TEAM LOCKER ROOM");
        this.roomFactory = new WestRoomCreator();
        Room westRoom = roomFactory.createRoom("AWAY TEAM LOCKER ROOM");
        this.roomFactory = new SouthRoomCreator();
        Room southRoom = roomFactory.createRoom("EQUIPMENT STORAGE");
        this.roomFactory = new NorthRoomCreator();
        Room northRoom = roomFactory.createRoom("GREEN ROOM");

        centerRoom.setNorth(northRoom);
        centerRoom.setEast(eastRoom);
        centerRoom.setSouth(southRoom);
        centerRoom.setWest(westRoom);
        northRoom.setSouth(centerRoom);
        eastRoom.setWest(centerRoom);
        southRoom.setNorth(centerRoom);
        westRoom.setEast(centerRoom);

        currentRoom = centerRoom;
    }

    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable) {
            ExitRoom exitRoom = (ExitRoom) currentRoom;
            if (exitRoom.isSpiderDead()) {
                isFinished = true;
                return (((Exitable) currentRoom).exit(player));
            } else if (!exitRoom.isSpiderDead()) {
                return "You cannot leave while the spider is still there.\n";
            }
        }

        return "You cannot exit the maze from this room.\n";
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable) {
            return ((Interactable) currentRoom).interact(player);
        }

        return "You cannot interact with this room.\n";
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable) {
            return ((Lootable) currentRoom).loot(player);
        }

        return "You cannot loot this room.\n";
    }

    public boolean move(char direction) {
        if (currentRoom.isValidDirection(direction)) {
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        } else if (currentRoom instanceof Exitable && Character.toLowerCase(direction) == 'x') {
            return true;
        }

        return false;
    }

    public String actionInfoMenu() {
        return "LIST OF POSSIBLE ACTIONS:\n" +
                "\tN = Move North\n" +
                "\tS = Move South\n" +
                "\tE = Move East\n" +
                "\tW = Move West\n" +
                "\tV = Check Your Inventory\n" +
                "\tI = Interact with Current Room\n" +
                "\tL = Loot Current Room\n" +
                "\tX = Attempt to Exit the Maze from the Current Room\n" +
                "\tD = Repeat Current Room's Description\n" +
                "\tQ = Quit Program\n" +
                "\tHelp = Show the List of Possible Actions (this menu)\n";
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player plr) {
        this.player = plr;
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public String getPlayerInventory() {
        return player.inventoryPrinter();
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public String getCurrentRoomName() {
        return "CURRENT LOCATION: " + currentRoom.getName();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription(player);
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean bool) {
        isFinished = bool;
    }

    public void resetMaze() {
        constructionSiteMazeBuilder();
        this.player = new Player();
        isFinished = false;
    }
}
