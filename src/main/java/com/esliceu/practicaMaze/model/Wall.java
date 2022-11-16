package com.esliceu.practicaMaze.model;

public class Wall implements MapSite{
    public Wall() {
    }
    @Override
    public String toString() {
        return "Wall";
    }

    @Override
    public void enter(Player player) {
        //No se puede pasar
    }
}
