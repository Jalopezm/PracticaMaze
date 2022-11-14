package com.esliceu.practicaMaze.model;

import java.math.RoundingMode;

public class Door implements MapSite{
    private Room room1;
    private Room room2;

    private boolean open = false;

    Door(Room room1,Room room2){
        this.room1 = room1;
        this.room2 = room2;
    }

    public void open() {
        this.open = true;
    }
    public boolean isOpen(){
        return this.open;
    }

    @Override
    public void enter(Player player) {
        if (!this.open){
            //Busacar key en inventario Player
            //y abrir la puerta
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
