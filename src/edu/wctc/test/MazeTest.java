package edu.wctc.test;

import edu.wctc.*;
import edu.wctc.rooms.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static edu.wctc.ItemType.*;

/**
 * This is the JUnit test file made for method testing.
 *
 * */

public class MazeTest {
    private Maze maze;
    private MazeController mazeCon;
    private Room roomTester;
    private Player player;
    private Inventory inventory;
    private ItemType item1;
    private ItemType item2;

    @Before
    public void setUp() {
        maze = Maze.getMaze();
        mazeCon = new MazeController();
        player = new Player();
        inventory = new Inventory();
        item1 = CROWBAR;
        item2 = SHOVEL;
        player.addToInventory(item1);
    }


    // PLAYER TESTING:
    @Test
    public void testGetInventory() {
        assertTrue("The player's inventory should be an Inventory",player.getInventory() instanceof Inventory);
    }

    @Test
    public void testGetInventoryArray() {
        assertTrue("An inventory should exist as an ArraList of Items",
                player.getInventoryArray() instanceof ArrayList<ItemType>);
    }

    @Test
    public void testInventoryPrinter() {
        assertTrue("This method should return a string",player.inventoryPrinter() instanceof String);
    }

    @Test
    public void testDoesInventoryContain() {
        assertTrue("The player's inventory should now contain a crowbar",player.doesInventoryContain(CROWBAR));
    }

    @Test
    public void testAddToInventory() {
        player.addToInventory(item2);
        assertTrue("The player's inventory should now contain a shovel",player.doesInventoryContain(SHOVEL));
    }

    @Test
    public void testGetScore() {
        assertTrue("The Test Player's score should currently be at zero points",player.getScore() == 0);
    }

    @Test
    public void testAddToScore() {
        player.addToScore(50);
        assertTrue("The player's score should now be at fifty points",player.getScore() == 50);
    }

    // INVENTORY TESTING:
    @Test
    public void testInvAddToInventory() {
        inventory.invAddToInventory(KEY);
        assertTrue("The player's inventory should now have a key",inventory.invGetInventory().contains(KEY));
    }

    @Test
    public void testInvGetInventory() {
        assertTrue("The test inventory should be an Inventory",inventory instanceof Inventory);
    }

    @Test
    public void testIsInventoryEmpty() {
//        inventory.invAddToInventory(FANG);
        assertTrue("The test inventory should be empty",inventory.isInventoryEmpty());
    }


    // MAZE TESTING:
    @Test
    public void testGetMaze() {
        assertTrue("The maze should be a Maze",maze instanceof Maze);
    }

    @Test
    public void testExitCurrentRoom() {
        maze.resetMaze();
        solveMaze(maze);
        assertTrue("You should have exited the maze",maze.isFinished());
    }

    @Test
    public void testInteractCurrentRoom() {
        maze.resetMaze();
        assertTrue("You should have interacted with a room",
                interactWithARoom(maze, false)
                        .contains("It took some considerable effort, but it opened up!"));
    }

    @Test
    public void testLootCurrentRoom() {
        maze.resetMaze();
        assertTrue("The player should have looted the current room",
                interactWithARoom(maze, true).contains("It was added to your inventory"));
    }

    @Test
    public void testMove() {
        maze.resetMaze();
        boolean move1 = maze.move('n');
        boolean move2 = !maze.move('e');
        boolean move3 = maze.move('s');
        boolean move4 = maze.move('w');
        boolean move5 = !maze.move('n');

        assertTrue("The player should have made a specific series of moves",
                move1 && move2 && move3 && move4 && move5);
    }

    @Test
    public void testActionInfoMenu() {
        assertTrue("The action help menu should contain the right information",
                maze.actionInfoMenu().contains("Repeat Current Room's Description"));
    }

    @Test
    public void testGetPlayer() {
        assertTrue("The Maze Player should be a Player", maze.getPlayer() instanceof Player);
    }

    @Test
    public void testGetPlayerScore() {
        maze.resetMaze();
        player.setScore(150);
        maze.setPlayer(player);
        assertTrue("The Maze Player should have a score of 150", maze.getPlayerScore() == 150);
    }

    @Test
    public void testGetPlayerInventory() {
        maze.resetMaze();
        player = new Player();
        player.addToInventory(CROWBAR);
        maze.setPlayer(player);
        assertTrue("This method should show that the Maze PLayer's inventory has a crowbar",
                maze.getPlayerInventory().contains("CROWBAR"));
    }

    @Test
    public void getCurrentRoomName() {
        maze.resetMaze();
        assertTrue("The current room's name should be correct", maze.getCurrentRoomName().contains("THE ARENA"));
    }

    @Test
    public void testGetCurrentRoomDescription() {
        maze.resetMaze();
        maze.move('e');
        assertTrue("The current room's description should be correct", maze.getCurrentRoomDescription().contains("You attempt to open it outright, but it is locked"));
    }

    @Test
    public void testGetCurrentRoomExits() {
        maze.resetMaze();
        maze.move('w');
        assertTrue("The current room's exits should be correct", maze.getCurrentRoomExits().contains("East"));
    }

    @Test
    public void testIsFinished() {
        maze.resetMaze();
        solveMaze(maze);
        assertTrue("The maze should be finished", maze.isFinished());
    }

    @Test
    public void testSetIsFinished() {
        maze.resetMaze();
        solveMaze(maze);
        maze.setIsFinished(false);
        assertTrue("The maze should not be finished", !maze.isFinished());
    }


    // ROOM TESTING:
    @Test
    public void testGetDescription() {
        maze.resetMaze();
        maze.move('s');
        roomTester = maze.getCurrentRoom();
        player = maze.getPlayer();
        String description = roomTester.getDescription(player);
        assertTrue("The current room's description should have the correct information",
                description.contains("Your initial reaction when you enter this room is disappointment"));
    }

    @Test
    public void testGetExits() {
        maze.resetMaze();
        maze.move('e');
        roomTester = maze.getCurrentRoom();
        assertTrue("The current Room should have the proper exits available", roomTester.getExits().contains("West"));
    }

    @Test
    public void testGetName() {
        maze.resetMaze();
        maze.move('n');
        roomTester = maze.getCurrentRoom();
        String roomName = roomTester.getName();
        assertTrue("The current Room should have the proper name", roomName.contains("GREEN ROOM"));
    }

    @Test
    public void testIsValidDirection() {
        maze.resetMaze();
        maze.move('w');
        roomTester = maze.getCurrentRoom();
        assertTrue("The current Room should have the proper name", !roomTester.isValidDirection('w'));
    }

    @Test
    public void testGetAdjoiningRoom() {
        maze.resetMaze();
        maze.move('s');
        roomTester = maze.getCurrentRoom();
        assertTrue("The current Room should have the proper name", roomTester.getAdjoiningRoom('n') instanceof CenterRoom);
    }


    // MAZE CONTROLLER TEST:
    @Test
    public void testTakeMoveAction() {
        maze.resetMaze();
        mazeCon.takeMoveAction(maze, "e");
        roomTester = maze.getCurrentRoom();
        assertTrue("The current Room should be the correct type", roomTester instanceof EastRoom);
    }

    @Test
    public void testTakeLootAction() {
        maze.resetMaze();
        interactWithARoom(maze, false);
        assertTrue("The Controller should take a loot action successfully",
                mazeCon.takeLootAction(maze).contains("It was added to your inventory"));
    }

    @Test
    public void testTakeInteractAction() {
        maze.resetMaze();
        preInteractAction(maze);
        assertTrue("The Controller should take an interact action successfully",
                mazeCon.takeInteractAction(maze).contains("It took some considerable effort, but it opened up"));
    }

    @Test
    public void testTakeExitAction() {
        maze.resetMaze();
        solveMazeNoExit(maze);
        assertTrue("The Controller should take an exit action successfully",
                mazeCon.takeExitAction(maze).contains("Congratulations! You have successfully completed the maze!"));
    }

    @Test
    public void testTakeShowInventoryAction() {
        maze.resetMaze();
        solveMazeNoExit(maze);
        assertTrue("The Controller should correctly show the contents of the Maze Player's inventory",
                mazeCon.takeShowInventoryAction(maze).contains("FANG"));
    }

    @Test
    public void testTakeRoomDescriptionAction() {
        maze.resetMaze();
        mazeCon.takeMoveAction(maze, "n");
        assertTrue("The Controller should correctly show the description of the current room",
                mazeCon.takeRoomDescriptionAction(maze).contains("you notice a door to the outside just behind the"));
    }

    @Test
    public void testTakeHelpAction() {
        maze.resetMaze();
        assertTrue("The Controller should correctly show the contents of the action help menu",
                mazeCon.takeHelpAction(maze).contains("Repeat Current Room's Description"));
    }

    @Test
    public void testTakeQuitAction() {
        maze.resetMaze();
        interactWithARoom(maze, true);
        assertTrue("The Controller should correctly show the quit prompt",
                mazeCon.takeQuitAction(maze).contains("Thanks for playing!"));
    }



    //  !!! SPOILERs: !!!



    public void solveMaze(Maze maze) {
        maze.move('w');
        maze.lootCurrentRoom();
        maze.move('e');
        maze.interactWithCurrentRoom();
        maze.lootCurrentRoom();
        maze.move('s');
        maze.interactWithCurrentRoom();
        maze.lootCurrentRoom();
        maze.move('n');
        maze.move('e');
        maze.interactWithCurrentRoom();
        maze.lootCurrentRoom();
        maze.move('w');
        maze.move('n');
        maze.interactWithCurrentRoom();
        maze.lootCurrentRoom();
        maze.exitCurrentRoom();
    }

    public void solveMazeNoExit(Maze maze) {
        maze.move('w');
        maze.lootCurrentRoom();
        maze.move('e');
        maze.interactWithCurrentRoom();
        maze.lootCurrentRoom();
        maze.move('s');
        maze.interactWithCurrentRoom();
        maze.lootCurrentRoom();
        maze.move('n');
        maze.move('e');
        maze.interactWithCurrentRoom();
        maze.lootCurrentRoom();
        maze.move('w');
        maze.move('n');
        maze.interactWithCurrentRoom();
        maze.lootCurrentRoom();
    }

    public String interactWithARoom(Maze maze, boolean lootRoom) {
        maze.move('w');
        maze.lootCurrentRoom();
        maze.move('e');
        if (lootRoom) {
            maze.interactWithCurrentRoom();
            return maze.lootCurrentRoom();
        } else {
            return maze.interactWithCurrentRoom();
        }
    }

    public void preInteractAction(Maze maze) {
        maze.move('w');
        maze.lootCurrentRoom();
        maze.move('e');
    }

    // Oh, and just in case you never played the Half-Life games, the Crowbar is a tribute to them.

}
