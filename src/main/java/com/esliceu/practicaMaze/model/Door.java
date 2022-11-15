package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.DoorService;

import javax.print.DocFlavor;
import java.math.RoundingMode;

public class Door extends DoorService {
    private Room room1;
    private Room room2;

    public Door(){
    }
    public Door(Room room1, Room room2){
        this.room1 = room1;
        this.room2 = room2;
    }

    public Room getRoom1() {
        return room1;
    }
    public Room getRoom2() {
        return room2;
    }
}
