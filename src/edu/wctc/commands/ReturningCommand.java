package edu.wctc.commands;

/**
 * This Command Interface was created to allow commands to return a value of any specified type.
 * Most of the methods used in the commands return a string, but there might come a time you want it to return an
 * integer, or some other data type instead.
 * Making this associated with a generic data type allows for the flexibility to choose what is being returned, which
 * subsequently adds that same flexibility to the Controller as well.
 *
 * */

public interface ReturningCommand<DataType> {
    DataType execute();
}
