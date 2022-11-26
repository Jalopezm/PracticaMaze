package com.esliceu.practicaMaze.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private boolean winner;
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

    public int playerTotalCoins(Player player) {
        int counter = 0;
        List<Item> inv = player.getItemList();
        for (int i = 0; i < inv.size(); i++) {
            String item = inv.get(i).toString();
            if (item.equals("Coin")) {
                counter++;
            }
        }
        return counter;
    }

    public Object playerTotalKeys(Player player) {
        int counter = 0;
        List<Item> inv = player.getItemList();
        for (int i = 0; i < inv.size(); i++) {
            Item item = inv.get(i);
            if (item instanceof Key) {
                counter++;
            }
        }
        return counter;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isWinner() {
        return winner;
    }
}
