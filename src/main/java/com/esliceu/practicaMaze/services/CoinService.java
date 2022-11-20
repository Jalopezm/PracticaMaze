package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Item;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;

public class CoinService {
    public void getCoin(Item coin, Player player, Room room) {
        player.addItem(coin);
        room.deleteItem(1);
    }
}
