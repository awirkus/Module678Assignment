package edu.wctc.commands;

/**
 * This class was created as the original Command Interface.
 * Because it does not return a value, the 'ReturningCommand' Interface was created as well.
 * ReturningCommand was initially created as a secondary interface to this one; however, it turned out that most of
 * the commands needed to return a value of some kind (primarily strings), so ReturningCommand became more the
 * primary command interface.
 * This class ended up having minimal usage in the concrete command classes.
 *
 * */

public interface Command {
    void execute();
}
