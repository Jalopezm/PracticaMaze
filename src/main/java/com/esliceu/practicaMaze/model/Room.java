package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.RoomService;

public class Room extends RoomService {
    private int number;
    private Item item;
    private boolean target = false;
    public Room (){}

    public Room(int roomNumber) {
        this.number = roomNumber;
    }

    public int getNumber() {
        return number;
    }

}
