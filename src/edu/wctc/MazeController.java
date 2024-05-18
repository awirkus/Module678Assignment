package edu.wctc;

import edu.wctc.commands.*;

import java.util.Scanner;

/**
 * This class was created as a means to control the user's journey through the maze by utilizing the
 * Command Strategy Pattern.
 * Actions in the maze game are taken by utilizing the methods found in this class.
 * The methods in this class take advantage of several commands that were created to accompany the various actions you
 * can take in the game, as well as a few other pieces that impact the user interface directly.
 * Because the actions being taken and the interface involved are relatively unique, it was not programmed as a
 * universal controller, but rather one that could operate a Maze object for this game specifically.
 * This gives the flexibility to make additional Mazes utilizing the same set of controls in the future.
 * It also provides the option to modify actions later if there ends up being some change to the interface.
 * These actions could also be ported to a universal controller style if needed.
 *
 * */

public class MazeController {
    private Maze maze;

    private ReturningCommand moveAction;
    private ReturningCommand lootAction;
    private ReturningCommand interactAction;
    private ReturningCommand exitAction;
    private ReturningCommand showInventoryAction;
    private ReturningCommand descriptionAction;
    private ReturningCommand helpAction;
    private ReturningCommand quitGameAction;
    private Command pressEnter;
    private ReturningCommand actionInput;

    public String takeMoveAction(Maze maze, String direction) {
        moveAction = new MoveCommand(maze, direction);
        return (String) moveAction.execute();
    }

    public String takeLootAction(Maze maze) {
        lootAction = new LootCommand(maze);
        return (String) lootAction.execute();
    }

    public String takeInteractAction(Maze maze) {
        interactAction = new InteractCommand(maze);
        return (String) interactAction.execute();
    }

    public String takeExitAction(Maze maze) {
        exitAction = new ExitCommand(maze);
        return (String) exitAction.execute();
    }

    public String takeShowInventoryAction(Maze maze) {
        showInventoryAction = new ShowInventoryCommand(maze);
        return (String) showInventoryAction.execute();
    }

    public String takeRoomDescriptionAction(Maze maze) {
        descriptionAction = new RoomDescriptionCommand(maze);
        return (String) descriptionAction.execute();
    }

    public String takeHelpAction(Maze maze) {
        helpAction = new HelpCommand(maze);
        return (String) helpAction.execute();
    }

    public String takeQuitAction(Maze maze) {
        quitGameAction = new QuitCommand(maze);
        return (String) quitGameAction.execute();
    }

    public void givePressEnterPrompt() {
        pressEnter = new PressEnterPromptCommand();
        pressEnter.execute();
    }

    public String giveActionInputPrompt() {
        actionInput = new ActionInputCommand();
        return String.valueOf(actionInput.execute());
    }
}
