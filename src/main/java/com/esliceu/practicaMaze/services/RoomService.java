package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.excepcions.UnknownDirException;
import com.esliceu.practicaMaze.model.*;
import com.esliceu.practicaMaze.utils.GameUtil;

import java.util.EnumSet;

public class RoomService {
    public static Room createRoom(int roomId) {
        Room room = new Room(roomId);
        room.setNumber(roomId);
        return room;
    }

    public String movePlayer(String move, Player player) {
        GameUtil gameUtil = new GameUtil();
        String message = "";
        if (move != null) {
            if (Maze.getDirection(move)) {
                switch (Maze.Directions.valueOf(move)) {
                    case North:
                        message = gameUtil.go(player, Maze.Directions.North);
                        break;
                    case South:
                        message = gameUtil.go(player, Maze.Directions.South);
                        break;
                    case East:
                        message = gameUtil.go(player, Maze.Directions.East);
                        break;
                    case West:
                        message = gameUtil.go(player, Maze.Directions.West);
                }
            } else {
                throw new UnknownDirException();
            }

        }
        Room room = player.getCurrRoom();

        String myjson = GameService.getJsonInfo(room, player, message);

        if (room.isTarget()) {
            message = " WINNER!!";
            player.setWinner(true);
            myjson = GameService.getJsonInfo(room, player, message);
        }
        return myjson;
    }
}
