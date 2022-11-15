package com.esliceu.practicaMaze.model;

import com.esliceu.practicaMaze.services.RoomService;

public class Room  {

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

    public MapSite getSides(Maze.Directions dir) {
       return RoomService.getSides(dir);
    }
    public void setTarget(boolean target) {
        RoomService.setTarget(target);
    }

    public void setSides(Maze.Directions dir, MapSite ms) {
        RoomService.setSides(dir,ms);
    }

    public void setItem(Item it) {
        RoomService.setItem(it);
    }

    public void enter(Player player) {
        RoomService.enter(player);
    }
}
