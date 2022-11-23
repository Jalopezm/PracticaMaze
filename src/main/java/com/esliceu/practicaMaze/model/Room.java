package com.esliceu.practicaMaze.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Room implements MapSite{

    private int number;
    private Item[] item = new Item[2];
    private  boolean target = false;

    private Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public Room(int roomNumber) {
        this.number = roomNumber;
    }

    public int getNumber() {
        return number;
    }

    public static Room createRoom(int roomId) {
        Room room = new Room(roomId);
        room.setNumber(roomId);
        return room;
    }

    public MapSite getSides(Maze.Directions dir) {
        return this.sides.get(dir);
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public void setSides(Maze.Directions dir, MapSite ms) {
        this.sides.put(dir, ms);
    }

    public void setItem(String item , Item it) {
        if (item == "Coin"){
        this.item[1] = it;
        }else{
            this.item[0] = it;
        }
    }

    public Item getItem(int i) {
        return this.item[i];
    }

    @Override
    public String enter(Player player) {
        String message = "";
        if (this.item != null) {
            message = "Hay un Item en la Sala:";
        }
        return message;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void deleteItem(int i) {
        this.item[i] = null;
    }

    public boolean haveCoin() {
        if (this.item[1] != null){
            System.out.println("yes");
            return true;
        }
    return false;
    }

    public boolean haveKey() {
        if (this.item[0] != null){
            System.out.println("yes");
            return true;
        }
        return false;
    }
}
