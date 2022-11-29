package com.esliceu.practicaMaze.model;

public class Winner {
    String name;
    String mazeName;
    int id;
    long time;

    public String getWinnerName() {
        return this.name;
    }

    public String getMazeSolved() {
        return this.mazeName;
    }

    public int getTime() {
        return (int) this.time;
    }

    public void setWinnerId(int id) {
        this.id = id;
    }

    public void setWinnerName(String playerName) {
        this.name = playerName;
    }

    public void setMazeName(String mazeName) {
        this.mazeName = mazeName;
    }

    public void setTime(long time) {
        this.time = time;
    }
    public String getTimeFormatted() {
        int minutes = (int)Math.floor(time/60000);
        int seconds = (int)Math.floor((time/1000) - (minutes*60));
        String minutesStr = "" + minutes;
        String secondsStr = "" + seconds;
        if(minutes < 10) minutesStr = "0" + minutes;
        if(seconds < 10) secondsStr = "0" + seconds;

        return minutesStr + "'" + secondsStr + '"';
    }
}
