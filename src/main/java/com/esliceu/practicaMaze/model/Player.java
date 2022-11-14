package com.esliceu.practicaMaze.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currRoom;
    private List<Item> invent = new ArrayList<>();

    public Room getCurrRoom() {
        return currRoom;
    }
}
