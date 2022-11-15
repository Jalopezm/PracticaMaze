package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.KeyService;

public class Key implements Item{
    private String name;

    public Key(String name){
        this.name = name;
    }
    public void open(Door door) {
        KeyService.open(door);
    }
    public void addDoor(Door d) {
        KeyService.addDoor(d);
    }

}
