package edu.wctc.commands;

import java.util.Scanner;

/**
 * This command class was made to provide the maze controller with the ability to provide the 'What would you like
 * to do?...' user input prompt.
 * I debated whether or not to create a command for it, but decided to follow through on it only because it is
 * something that is directly related to game control and the user interface, which is what the maze controller is
 * meant to take care of.
 * (The same can be said for the PressEnterPromptCommand class)
 *
 * */

public class ActionInputCommand implements ReturningCommand<String> {
    public ActionInputCommand() {
    }

    @Override
    public String execute() {
        return actionInputPrompt();
    }

    public String actionInputPrompt() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.print("What would you like to do?\n('help' for Action Info)\n\t>> ");
        String direction = keyboard.nextLine().toLowerCase();
        System.out.println();
        return direction;
    }
}
