package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

import java.util.List;

public class KeyService {
    int counter = 0;
    public String getKey(Key key , Player player, Room room) {

        List<Item> inv = player.getItemList();
        for (int i = 0; i < inv.size(); i++) {
            String item = inv.get(i).toString();
            System.out.println(item);
            if (item.equals("Coin")){
                counter++;
                inv.remove(i);
                room.deleteItem(0);
                break;
            }
        }
        if (counter == key.getValue()){
            counter = 0;
            player.addItem(key);
        }

        return null;
    }
}
