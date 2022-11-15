package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

import java.util.List;

public class DoorService implements MapSite {
    private Room room1 = new Door().getRoom1();
    private Room room2 = new Door().getRoom2();
    private boolean open = false;
    public void open() {
        this.open = true;
    }
    public boolean isOpen(){
        return this.open;
    }

    @Override
    public void enter(Player player) {
        if (!this.open){
            List<Item> items = player.getItemList();
            items.stream()
                    .filter(i -> i instanceof Key)
                    .map(i -> (Key) i)
                    .forEach(k -> k.open((Door) this));
        }
        if (this.open){
            Room room = getNextToRoom(player.getCurrRoom());
        }else{
            //NO  se puede abrir la puerta
        }
    }

    public Room getNextToRoom(Room currRoom){
        if (room1.getNumber() == currRoom.getNumber()){
            return room2;
        }
        return room1;
    }
}
