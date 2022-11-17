package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Maze;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;
import org.json.simple.JSONObject;


public class GameService {

    public static String getJsonInfo(Room room, Player player) {
        JSONObject jsonObject = new JSONObject();
            JSONObject walls = new JSONObject();
            walls.put("ID",room.getNumber());
            walls.put("N",room.getSides(Maze.Directions.North).toString());
            walls.put("S",room.getSides(Maze.Directions.South).toString());
            walls.put("E",room.getSides(Maze.Directions.East).toString());
            walls.put("W",room.getSides(Maze.Directions.West).toString());
            jsonObject.put("Walls",walls);
            JSONObject itemRoom = new JSONObject();
            itemRoom.put("Coin",room.getItem(1));
            itemRoom.put("Key",room.getItem(0));
            jsonObject.put("items",itemRoom);

        return jsonObject.toJSONString();
    }
}
