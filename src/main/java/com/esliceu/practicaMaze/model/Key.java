package com.esliceu.practicaMaze.model;

import java.util.ArrayList;
import java.util.List;

public class Key {
    private List<Door> openableDoors = new ArrayList<>();
    private String name;

    public Key(String name){
        this.name = name;
    }

    public void addDoor(Door door){
        this.openableDoors.add(door);
    }

    public void openDoor(Door door){
        //Abrir Puerta
    }

}
