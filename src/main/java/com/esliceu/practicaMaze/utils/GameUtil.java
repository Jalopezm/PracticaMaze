package com.esliceu.practicaMaze.utils;

import com.esliceu.practicaMaze.model.*;

public class GameUtil {
    public void createMaze(int mazeId, Player player) {
        MazeBuilder mazeBuilder = new MazeBuilder();
        Maze maze = mazeBuilder.getMaze();
        switch (mazeId) {
            case 1:
                for (int i = 1; i <= 7; i++) {
                    mazeBuilder.createRoom(i);
                }

                Key key1 = new Key("1");
                key1.setValue(1);
                Coin coin = new Coin();
                mazeBuilder.buildDoor(2, 1, Maze.Directions.West, key1);
                mazeBuilder.buildHallWay(2, 3, Maze.Directions.East);

                mazeBuilder.buildHallWay(3, 6, Maze.Directions.East);
                mazeBuilder.buildHallWay(3, 4, Maze.Directions.South);

                Key key2 = new Key("2");
                key2.setValue(1);
                mazeBuilder.buildDoor(5, 4, Maze.Directions.West, key2);
                mazeBuilder.buildHallWay(5, 6, Maze.Directions.North);

                Key key3 = new Key("3");
                key3.setValue(2);
                mazeBuilder.buildDoor(6, 7, Maze.Directions.North, key3);
                mazeBuilder.setTarget(7);

                Room room1 = maze.getRoom(1);
                room1.setItem("Key3", key3);
                Room room2 = maze.getRoom(2);
                room2.setItem("Key2", key2);
                Room room3 = maze.getRoom(3);
                room3.setItem("Coin", coin);
                Room room4 = maze.getRoom(4);
                room4.setItem("Coin", coin);
                Room room5 = maze.getRoom(5);
                room5.setItem("Key1", key1);
                room5.setItem("Coin", coin);
                Room room6 = maze.getRoom(6);
                room6.setItem("Coin", coin);

                player.setCurrentRoom(room2);
                break;
            case 2:
                coin = new Coin();
                mazeBuilder.createRoom(1);
                mazeBuilder.createRoom(2);
                mazeBuilder.createRoom(3);
                mazeBuilder.createRoom(4);
                mazeBuilder.createRoom(5);
                mazeBuilder.createRoom(6);
                mazeBuilder.createRoom(7);
                mazeBuilder.createRoom(8);

                room2 = maze.getRoom(2);
                room2.setItem("Coin", coin);

                Room room7 = maze.getRoom(7);
                key1 = new Key("1");
                key1.setValue(2);
                room7.setItem("Key1", key1);
                room7.setItem("Coin", coin);

                room5 = maze.getRoom(5);
                room5.setItem("Coin", coin);

                room6 = maze.getRoom(6);
                key2 = new Key("2");
                key2.setValue(1);
                room6.setItem("Key2", key2);

                room4 = maze.getRoom(4);
                player.setCurrentRoom(room4);

                mazeBuilder.buildHallWay(2, 1, Maze.Directions.West);
                mazeBuilder.buildHallWay(1, 3, Maze.Directions.South);
                mazeBuilder.buildHallWay(2, 4, Maze.Directions.South);
                mazeBuilder.buildHallWay(3, 4, Maze.Directions.East);
                mazeBuilder.buildHallWay(4, 7, Maze.Directions.South);
                mazeBuilder.buildHallWay(3, 7, Maze.Directions.West);
                mazeBuilder.buildHallWay(2, 5, Maze.Directions.East);
                mazeBuilder.buildDoor(5, 6, Maze.Directions.East, key1);
                mazeBuilder.buildDoor(7, 8, Maze.Directions.South, key2);

                mazeBuilder.setTarget(8);
                break;
        }
    }

    public String go(Player player, Maze.Directions dir) {
        Room room = player.getCurrRoom();
        MapSite ms = room.getSides(dir);
        System.out.println("ROOM: " + room.getNumber());
        String message = ms.enter(player);
        return message;
    }
}
