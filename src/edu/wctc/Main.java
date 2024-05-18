package edu.wctc;

import edu.wctc.roomFactoryMethod.CenterRoomCreator;

import java.util.Scanner;

/**
 * Please Note:
 *
 * In addition to the required implementations, this program also implements the Command Design Pattern. Reference
 * the 'MazeController' class file for more information.
 *
 * Clarification on implimented design patterns can be found in 'Room' (Strategy), 'Maze' (Singleton),
 * 'RoomCreator' (Factory Method), and 'MazeController' (Command).
 *
 * */

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Maze maze = Maze.getMaze();
        MazeController mazeController = new MazeController();

        System.out.println("\n\n\n...\n\n\n" +
                "You wake up in the middle of a construction site with no memory of how you got there.\n" +
                "Looking up at the sky, you see that it is nighttime. As you look around, you notice \n" +
                "that the construction lights were left on and some projects were left unfinished, while\n" +
                "others appear to have been damaged. You get the feeling that whoever was here before\n" +
                "you must have left suddenly.\n");
        mazeController.givePressEnterPrompt();

        System.out.println(mazeController.takeHelpAction(maze));
        mazeController.givePressEnterPrompt();

        System.out.println(mazeController.takeRoomDescriptionAction(maze));;

        while (!maze.isFinished()) {

            String direction = mazeController.giveActionInputPrompt();

            switch (direction) {
                case "n":
                case "s":
                case "e":
                case "w":
                    System.out.println(mazeController.takeMoveAction(maze, direction));
                    break;
                case "i":
                    System.out.println(mazeController.takeInteractAction(maze));
                    break;
                case "l":
                    System.out.println(mazeController.takeLootAction(maze));
                    break;
                case "x":
                    System.out.println(mazeController.takeExitAction(maze));
                    break;
                case "v":
                    System.out.println(mazeController.takeShowInventoryAction(maze));
                    break;
                case "d":
                    System.out.println(mazeController.takeRoomDescriptionAction(maze));
                    break;
                case "q":
                    System.out.println(mazeController.takeQuitAction(maze));
                    break;
                case "help":
                    System.out.println(mazeController.takeHelpAction(maze));
                    break;
                default:
                    System.out.println("Invalid command. Try again.\n");
                    mazeController.givePressEnterPrompt();
            }
        }
    }

}
