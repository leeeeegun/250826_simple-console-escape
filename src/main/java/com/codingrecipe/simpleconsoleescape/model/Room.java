package com.codingrecipe.simpleconsoleescape.model;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String description;
    private Map<String, Room> exits;
    private Monster monster;
    private Item item;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        if (north != null) exits.put("북", north);
        if (east != null) exits.put("동", east);
        if (south != null) exits.put("남", south);
        if (west != null) exits.put("북", west);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }
    public Map<String, Room> getExits() {
        return exits;
    }
    public Monster getMonster() {
        return monster;
    }
    public Item getItem() {
        return item;
    }

    public void removeItem() {
        this.item = null;
    }
    public void removeMonster() {
        this.monster = null;
    }
}

