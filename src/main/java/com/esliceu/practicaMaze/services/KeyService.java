package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Door;

import java.util.ArrayList;
import java.util.List;

public class KeyService {
    private List<Door> openableDoors = new ArrayList<>();

    public void addDoor(Door d) {
        this.openableDoors.add(d);
    }

    public void open(Door door) {
        this.openableDoors
                .stream()
                .filter(d -> d.equals(door))
                .forEach(Door::open);
    }

}
