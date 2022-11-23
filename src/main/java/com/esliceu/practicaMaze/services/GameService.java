package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Maze;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;
import org.json.simple.JSONObject;


public class GameService {

    public static String getJsonInfo(Room room, Player player,String message) {
        JSONObject jsonObject = new JSONObject();
        JSONObject walls = new JSONObject();
        walls.put("ID", room.getNumber());
        walls.put("N", room.getSides(Maze.Directions.North).toString());
        walls.put("S", room.getSides(Maze.Directions.South).toString());
        walls.put("E", room.getSides(Maze.Directions.East).toString());
        walls.put("W", room.getSides(Maze.Directions.West).toString());
        walls.put("message",message);
        jsonObject.put("Walls", walls);
        JSONObject itemRoom = new JSONObject();
        if (room.getItem(1) != null) {
            itemRoom.put("Coin", room.getItem(1).toString());
        } else {
            itemRoom.put("Coin", "[null]");
        }
        itemRoom.put("totalCoin",player.playerTotalCoins(player));
        if (room.getItem(0) != null) {
            itemRoom.put("Key", room.getItem(0).toString());
        } else {
            itemRoom.put("Key", "[null]");
        }
        itemRoom.put("totalKeys",player.playerTotalKeys(player));
        jsonObject.put("items", itemRoom);
        JSONObject playerInv = new JSONObject();
        playerInv.put("Inv",player.getItemList().toString());
        jsonObject.put("Inv", playerInv);
        return jsonObject.toJSONString();
    }
}
