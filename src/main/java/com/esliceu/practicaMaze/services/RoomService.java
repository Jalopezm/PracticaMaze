package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

import java.util.HashMap;
import java.util.Map;

public class RoomService {
    private static Item item;
    private boolean target = false;

    private static Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public static Room createRoom(int roomId) {
        Room room = new Room(roomId);
        return room;
    }

    public static MapSite getSides(Maze.Directions dir) {
        return sides.get(dir);
    }

    public boolean isTarget() {
        return target;
    }

    public static void setTarget(boolean target) {
        target = target;
    }

    public static void setSides(Maze.Directions dir, MapSite ms) {
        sides.put(dir, ms);
    }

    public static void setItem(Item it) {
        item = it;
    }

    public static void enter(Player player) {
        if (item != null) {
            System.out.println("Has obtingut un ítem: " + item.toString());
            player.addItem(item);
            item = null;
        }
    }
}
