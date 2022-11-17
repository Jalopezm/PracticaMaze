package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;
import com.esliceu.practicaMaze.utils.GameUtil;

public class RoomService {
    public static Room createRoom(int roomId) {
        Room room = new Room(roomId);
        room.setNumber(roomId);
        return room;
    }

    public void movePlayer(String move, Player player) {
        GameUtil gameUtil = new GameUtil();
        if (move != null) {
            switch (Maze.Directions.valueOf(move)) {
                case North:
                    gameUtil.go(player, Maze.Directions.North);
                    break;
                case South:
                    gameUtil.go(player, Maze.Directions.South);
                    break;
                case East:
                    gameUtil.go(player, Maze.Directions.East);
                    break;
                case West:
                    gameUtil.go(player, Maze.Directions.West);
                    break;
            }
        }
    }
}
