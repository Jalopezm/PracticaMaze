package com.esliceu.practicaMaze.model;

public class Wall implements MapSite {
    public Wall() {
    }

    @Override
    public String toString() {
        return "Wall";
    }

    @Override
    public String enter(Player player) {
        return "YOU CAN'T CROSS A WALL";
    }
}
