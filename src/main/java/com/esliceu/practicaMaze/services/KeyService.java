package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

import java.util.List;

public class KeyService {

    int totalCoin = 0;
    public void getKey(Key key, Player player, Room room) {
        List<Item> inv = player.getItemList();
        for (int i = 0; i < inv.size(); i++) {
            String item = inv.get(i).toString();
            System.out.println(item);
            if (item.equals("Coin")){
                inv.remove(i);
                totalCoin++;
            }
        }
        System.out.println(totalCoin);
        System.out.println(key.getValue());
        if (totalCoin >= key.getValue()){
            player.addItem(key);
            room.deleteItem(0);
        }else{
            System.out.println("NO TIENES DINERO CABRON");
        }
    }
}
