package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.MapSite;
import com.esliceu.practicaMaze.model.Maze;
import com.esliceu.practicaMaze.model.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomService {
    private Map<Maze.Directions, MapSite> sides = new HashMap<>();
    public Room createRoom(int roomId){
        Room room = new Room();
        return room;
    }
}
