package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Maze;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;
import com.esliceu.practicaMaze.utils.MazeBuilder;
import org.json.simple.JSONObject;

import javax.swing.tree.RowMapper;

public class MazeService {

    public static String getJsonInfo(Room room, Player player) {
        JSONObject jsonObject = new JSONObject();
            JSONObject walls = new JSONObject();
            walls.put("ID",room.getNumber());
            walls.put("N",room.getSides(Maze.Directions.North).toString());
            walls.put("S",room.getSides(Maze.Directions.South).toString());
            walls.put("E",room.getSides(Maze.Directions.East).toString());
            walls.put("W",room.getSides(Maze.Directions.West).toString());
            jsonObject.put("Walls",walls);

        return jsonObject.toJSONString();
    }
}
