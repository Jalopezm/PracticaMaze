package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.excepcions.GetCoinException;
import com.esliceu.practicaMaze.model.Item;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;

import javax.servlet.RequestDispatcher;

public class CoinService {
    public String getCoin(Player player) {
        String myjson = "";
        Room room = player.getCurrRoom();
        Item coin = room.getItem(1);
        if (room.haveCoin()) {
            player.addItem(coin);
            room.deleteItem(1);
            String message = "YOU HAVE TAKEN A COIN";
            myjson = GameService.getJsonInfo(room, player, message);
        } else {
            throw new GetCoinException();
        }
        return myjson;
    }
}
