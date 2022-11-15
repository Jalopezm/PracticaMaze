package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

import java.util.List;

public class DoorService {
    static Door door = new Door();
    private static Room room1 = door.getRoom1();
    private static Room room2 = door.getRoom2();

    public static void enter(Player player) {
        if (!door.isOpen()){
            List<Item> items = player.getItemList();
            items.stream()
                    .filter(i -> i instanceof Key)
                    .map(i -> (Key) i)
                    .forEach(k -> k.open(door));
        }
        if (door.isOpen()){
            Room room = getNextToRoom(player.getCurrRoom());
        }else{
            //NO  se puede abrir la puerta
        }
    }
    public static Room getNextToRoom(Room currRoom){
        if (room1.getNumber() == currRoom.getNumber()){
            return room2;
        }
        return room1;
    }
}
