package com.esliceu.practicaMaze.model;

public class Winner {
    String name;
    String mazeName;
    int id;
    long time;

    public String getWinnerName() {
        return name;
    }

    public String getMazeSolved() {
        return mazeName;
    }

    public Object getTime() {
        return time;
    }

    public void setWinnerId(int id) {
        this.id = id;
    }

    public void setWinnerName(String playerName) {
        this.name = playerName;
    }

    public void setMazeSolved(String mazeName) {
        this.mazeName = mazeName;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
