package edu.wctc.commands;

import edu.wctc.Maze;

import java.util.Scanner;

/**
 * This command class was made to provide the maze controller with the ability to provide the 'Press ENTER...' prompt.
 * I debated whether or not to create a command for it, but decided to follow through on it only because it is
 * something that is directly related to game control and the user interface, which is what the maze controller is
 * meant to take care of.
 * (The same can be said for the ActionInputCommand class)
 *
 * */

public class PressEnterPromptCommand implements Command {
    public PressEnterPromptCommand() {
    }

    @Override
    public void execute() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Press ENTER to continue...");
        keyboard.nextLine();
        System.out.println("\n");
    }
}
