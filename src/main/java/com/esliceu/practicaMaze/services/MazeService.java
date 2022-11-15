package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.Maze;
import com.esliceu.practicaMaze.model.Room;
import com.esliceu.practicaMaze.utils.MazeBuilder;
import org.json.simple.JSONObject;

import javax.swing.tree.RowMapper;

public class MazeService {

    public static String getJsonInfo() {
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < 7 ; i++) {
            Room room = new Room(i);
            JSONObject walls = new JSONObject();
            walls.put("N",room.getSides(Maze.Directions.North));
            walls.put("S",room.getSides(Maze.Directions.South));
            walls.put("E",room.getSides(Maze.Directions.East));
            walls.put("W",room.getSides(Maze.Directions.West));
            jsonObject.put("Walls",walls);
        }

        return jsonObject.toJSONString();
    }
}
