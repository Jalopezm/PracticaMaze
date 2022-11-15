package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Door;

import java.util.ArrayList;
import java.util.List;

public class KeyService {
    private static List<Door> openableDoors = new ArrayList<>();

    public static void addDoor(Door d) {
        openableDoors.add(d);
    }

    public static void open(Door door) {
        openableDoors
                .stream()
                .filter(d -> d.equals(door))
                .forEach(Door::open);
    }

}
