package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.PlayerService;

import java.util.ArrayList;
import java.util.List;

public class Player  {
    private Room currRoom;
    private List<Item> invent = new ArrayList<>();

    public void addItem(Item it) {
        this.invent.add(it);
    }

    public List<Item> getItemList() {
        return this.invent;
    }


    public Room getCurrRoom() {
        return currRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currRoom = currentRoom;
        currentRoom.enter(this);
    }
}
