package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Item;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;

public class CoinService {
    public String getCoin(Item coin, Player player, Room room) {
        player.addItem(coin);
        room.deleteItem(1);
        return "YOU HAVE TAKEN A COIN";
    }
}
