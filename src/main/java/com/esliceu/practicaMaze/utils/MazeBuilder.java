package com.esliceu.practicaMaze.utils;

import com.esliceu.practicaMaze.model.Room;
import com.esliceu.practicaMaze.services.RoomService;

public class MazeBuilder {
    public void createRoom(int roomNumber){
        Room room = new RoomService().createRoom(roomNumber);
    }
}
