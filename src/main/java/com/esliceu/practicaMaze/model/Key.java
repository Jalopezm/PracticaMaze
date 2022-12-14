package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.KeyService;

import java.util.ArrayList;
import java.util.List;

public class Key implements Item {
    private String name;
    private int value;
    private List<Door> openableDoors = new ArrayList<>();

    public Key(String name) {
        this.name = name;

    }

    public void setValue(int keyValue) {
        value = keyValue;
    }

    public void addDoor(Door d) {
        openableDoors.add(d);
    }

    public void open(Door door) {
        openableDoors
                .stream()
                .filter(d -> d.equals(door))
                .forEach(Door::open);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Key{" +
                "name='" + name + '\'' +
                ", openableDoors=" + openableDoors +
                '}';
    }
}
