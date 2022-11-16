package com.esliceu.practicaMaze.utils;

import com.esliceu.practicaMaze.model.Key;
import com.esliceu.practicaMaze.model.Maze;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;

public class GameUtil {
    public void createMaze(int mazeId, Player player){
        MazeBuilder mazeBuilder = new MazeBuilder();
        Maze maze = mazeBuilder.getMaze();
        switch (mazeId){
            case 1:
                for (int i = 1; i <= 7; i++) {
                    mazeBuilder.createRoom(i);
                }

                Key key1 = new Key("1");
                mazeBuilder.buildDoor(2,1,Maze.Directions.West,key1);
                mazeBuilder.buildHallWay(2,3,Maze.Directions.East);

                mazeBuilder.buildHallWay(3,6,Maze.Directions.East);
                mazeBuilder.buildHallWay(3,4,Maze.Directions.South);

                Key key2 = new Key("2");
                mazeBuilder.buildDoor(4,5,Maze.Directions.East,key2);
                mazeBuilder.buildHallWay(5,6,Maze.Directions.North);

                Key key3 = new Key("3");
                mazeBuilder.buildDoor(6,7,Maze.Directions.North,key3);
                mazeBuilder.setTarget(7);

                Room room1 = maze.getRoom(1);
                room1.setItem(key1);
                Room room2 = maze.getRoom(2);
                room2.setItem(key2);
                Room room5 = maze.getRoom(5);
                room5.setItem(key3);
                player.setCurrentRoom(room2);
                break;
            case 2:
                mazeBuilder.createRoom(1);
                mazeBuilder.createRoom(2);

                Key key4 = new Key("1");
                mazeBuilder.buildDoor(2,1,Maze.Directions.East,key4);
                Room room = maze.getRoom(1);
                System.out.println(room.getSides(Maze.Directions.North).toString());
                System.out.println(room.getSides(Maze.Directions.South).toString());
                System.out.println(room.getSides(Maze.Directions.East).toString());
                System.out.println(room.getSides(Maze.Directions.West).toString());
                player.setCurrentRoom(room);
                break;
        }
    }
}
