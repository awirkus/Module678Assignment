package edu.wctc;

import java.util.ArrayList;

/**
 * This is the class that represents the user's inventory in the maze game.
 *
 * */

public class Inventory {
    private ArrayList<ItemType> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void invAddToInventory(ItemType item) {
        inventory.add(item);
    }

    public ArrayList<ItemType> invGetInventory() {
        return inventory;
    }

    public boolean isInventoryEmpty() {
        if (inventory.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder inventoryList = new StringBuilder("CURRENT INVENTORY:\n");

        for (ItemType item : inventory) {
            if (item != null) {
                inventoryList.append("\t" + item + "\n");
            }
        }

        if (isInventoryEmpty()) {
            inventoryList.append("\t(empty)" + "\n");
        }

        return inventoryList.toString();
    }
}
