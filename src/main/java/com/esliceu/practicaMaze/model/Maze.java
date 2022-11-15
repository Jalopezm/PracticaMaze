package com.esliceu.practicaMaze.model;

import java.util.HashMap;
import java.util.Map;

public class Maze {
    public enum Directions {
        North, South, East, West
    }
    Map<Integer, Room> rooms = new HashMap<>();

    public void addRoom(int numRoom, Room room) {
        rooms.put(numRoom, room);
    }

    public Room getRoom(int numRoom) {
        System.out.println("Room"+rooms);
        return rooms.get(numRoom);
    }

}
