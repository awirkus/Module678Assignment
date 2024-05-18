package edu.wctc;

import java.util.ArrayList;

/**
 * This is the class that represents the user in the maze game.
 *
 * */

public class Player {
    private Inventory inventory;
    private int score = 0;
    private int inventoryIndex = 0;

    public Player() {
        this.inventory = new Inventory();
        this.score = score;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ArrayList<ItemType> getInventoryArray() {
        return inventory.invGetInventory();
    }

    public String inventoryPrinter() {
        return inventory.toString();
    }

    public void addToInventory(ItemType item) {
        inventory.invAddToInventory(item);
    }

    public boolean doesInventoryContain(ItemType item) {
        if (inventory.invGetInventory().contains(item)) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public void setScore(Integer number) {
        this.score = number;
    }
}
