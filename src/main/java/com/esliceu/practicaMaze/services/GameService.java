package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Maze;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;
import org.json.simple.JSONObject;


public class GameService {

    public static String getJsonInfo(Room room, Player player) {
        JSONObject jsonObject = new JSONObject();
        JSONObject walls = new JSONObject();
        walls.put("ID", room.getNumber());
        walls.put("N", room.getSides(Maze.Directions.North).toString());
        walls.put("S", room.getSides(Maze.Directions.South).toString());
        walls.put("E", room.getSides(Maze.Directions.East).toString());
        walls.put("W", room.getSides(Maze.Directions.West).toString());
        jsonObject.put("Walls", walls);
        JSONObject itemRoom = new JSONObject();
        if (room.getItem(1) != null) {
            itemRoom.put("Coin", room.getItem(1).toString());
        } else {
            itemRoom.put("Coin", "[null]");
        }
        if (room.getItem(0) != null) {
            itemRoom.put("Key", room.getItem(0).toString());
        } else {
            itemRoom.put("Key", "[null]");
        }
        jsonObject.put("items", itemRoom);
        JSONObject playerInv = new JSONObject();
        playerInv.put("Inv",player.getItemList().toString());
        jsonObject.put("Inv", playerInv);
        return jsonObject.toJSONString();
    }
}
