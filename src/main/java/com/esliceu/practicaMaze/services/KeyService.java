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
                totalCoin++;
            }
            if (totalCoin >= key.getValue()){
                player.addItem(key);
                room.deleteItem(0);
                deleteCoin(totalCoin,inv);
                break;
            }
        }
        System.out.println(totalCoin);
        System.out.println(key.getValue());
    }

    private void deleteCoin(int totalCoin, List<Item> inv) {
        int counter=0;
        for (int i = 0; i < inv.size(); i++) {
            String item = inv.get(i).toString();
            System.out.println(item);
            if (item.equals("Coin")){
                counter++;
                inv.remove(i);
            }
            if (counter == totalCoin){
                counter=0;
                break;
            }
        }
    }
}
