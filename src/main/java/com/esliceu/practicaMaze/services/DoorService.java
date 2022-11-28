package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

public class DoorService {
    public String open(String dir, Player player) {
        String myjson = "";
        Room room = player.getCurrRoom();
        MapSite ms = room.getSides(Maze.Directions.valueOf(dir));
        String message = "";
        if (ms instanceof Door) {
            ((Door) ms).openDoor(player);
            if (((Door) ms).isOpen()){
                message = "THERE IS A HALLWAY";
            }else {
                message = "YOU DON'T HAVE THE KEY";
            }
        } else if (ms instanceof Wall) {
            message = "YOU CAN'T CROSS A WALL";
        }
        myjson = GameService.getJsonInfo(room, player, message);
        return myjson;
    }
}
