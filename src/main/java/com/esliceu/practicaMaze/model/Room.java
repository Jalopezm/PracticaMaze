package com.esliceu.practicaMaze.model;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private int number;
    private Item item;
    private boolean target = false;
    private Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public Room(int roomNumber) {
        this.number = roomNumber;
    }

    public int getNumber() {
        return number;
    }

}
