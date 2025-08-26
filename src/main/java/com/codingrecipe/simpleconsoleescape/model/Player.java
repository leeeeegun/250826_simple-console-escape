package com.codingrecipe.simpleconsoleescape.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int hp;
    private int attackPower;
    private List<Item> inventory;

    public Player(int hp, int attackPower) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.inventory = new ArrayList<>();
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public boolean hasItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public int getHp() {
        return hp;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public List<Item> getInventory() {
        return inventory;
    }

}
