package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

import java.util.List;

public class KeyService {
    int counter = 0;
    String myjson = "";

    public String getKey(Player player) {
        Room room = player.getCurrRoom();
        Key key = (Key) room.getItem(0);

        if (room.haveKey()) {
            if (counter < key.getValue()) {
                String message = "NOT ENOUGH COINS";
                if (player.playerTotalCoins(player) >= key.getValue()) {
                    for (int i = 0; i < key.getValue(); i++) {
                        List<Item> inv = player.getItemList();
                        for (int j = 0; j < inv.size(); j++) {
                            Object item = inv.get(j);
                            if (item instanceof Coin) {
                                counter++;
                                inv.remove(j);
                                room.deleteItem(0);
                                break;
                            }
                        }
                    }
                }
                if (counter == key.getValue()) {
                    counter = 0;
                    player.addItem(key);
                    message = "YOU GOT A KEY";
                }
                return myjson = GameService.getJsonInfo(room, player, message);
            }
        }
        return myjson;
    }
}
