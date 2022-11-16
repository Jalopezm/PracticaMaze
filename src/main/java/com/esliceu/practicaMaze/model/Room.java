package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.RoomService;

import java.util.HashMap;
import java.util.Map;

public class Room implements MapSite{

    private int number;
    private  Item item;
    private  boolean target = false;

    private Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public Room(int roomNumber) {
        this.number = roomNumber;
    }

    public int getNumber() {
        return number;
    }

    public static Room createRoom(int roomId) {
        Room room = new Room(roomId);
        room.setNumber(roomId);
        return room;
    }

    public MapSite getSides(Maze.Directions dir) {
        return this.sides.get(dir);
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public void setSides(Maze.Directions dir, MapSite ms) {
        this.sides.put(dir, ms);
    }

    public void setItem(Item it) {
        this.item = it;
    }
    @Override
    public void enter(Player player) {
        if (this.item != null) {
            System.out.println("Has obtingut un ítem: " + this.item.toString());
            player.addItem(item);
            this.item = null;
        }
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
