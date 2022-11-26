package com.esliceu.practicaMaze.utils;

import com.esliceu.practicaMaze.model.*;
import com.esliceu.practicaMaze.services.RoomService;

public class MazeBuilder {
    private Maze maze = new Maze();

    public void createRoom(int roomNumber) {
        Room room = RoomService.createRoom(roomNumber);
        room.setSides(Maze.Directions.North, new Wall());
        room.setSides(Maze.Directions.South, new Wall());
        room.setSides(Maze.Directions.East, new Wall());
        room.setSides(Maze.Directions.West, new Wall());
        maze.addRoom(roomNumber, room);
    }

    public void setTarget(int nroom) {
        this.maze.getRoom(nroom).setTarget(true);
    }

    public void buildHallWay(int roomFrom, int roomTo, Maze.Directions dir) {
        Door door = buildDoorInternal(roomFrom, roomTo, dir);
        door.open();
    }

    private Door buildDoorInternal(int roomFrom, int roomTo, Maze.Directions dir) {
        Room r1 = maze.getRoom(roomFrom);
        Room r2 = maze.getRoom(roomTo);
        Door door = new Door(r1, r2);
        r1.setSides(dir, door);
        r2.setSides(getOppositeSide(dir), door);
        return door;
    }

    private Maze.Directions getOppositeSide(Maze.Directions dir) {
        switch (dir) {
            case North:
                return Maze.Directions.South;
            case South:
                return Maze.Directions.North;
            case West:
                return Maze.Directions.East;
            case East:
                return Maze.Directions.West;
        }
        throw new RuntimeException("Direcció no reconeguda");
    }

    public void buildDoor(int roomFrom, int roomTo, Maze.Directions dir, Key key) {
        Door d = buildDoorInternal(roomFrom, roomTo, dir);
        key.addDoor(d);
    }

    public Maze getMaze() {
        return this.maze;
    }
}
