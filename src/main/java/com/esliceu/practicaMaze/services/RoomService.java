package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

import java.util.HashMap;
import java.util.Map;

public class RoomService {
    private Item item;
    private boolean target = false;

    private Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public static Room createRoom(int roomId) {
        Room room = new Room();
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

    public void enter(Player player) {
        if (this.item != null) {
            System.out.println("Has obtingut un ítem: " + this.item.toString());
            player.addItem(this.item);
            this.item = null;
        }
    }
}
