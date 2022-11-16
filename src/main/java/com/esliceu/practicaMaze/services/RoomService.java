package com.esliceu.practicaMaze.services;

import com.esliceu.practicaMaze.model.*;

import java.util.HashMap;
import java.util.Map;

public class RoomService {
    public static Room createRoom(int roomId) {
        Room room = new Room(roomId);
        room.setNumber(roomId);
        return room;
    }

}
