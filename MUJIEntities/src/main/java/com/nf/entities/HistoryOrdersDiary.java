package com.nf.entities;

public class HistoryOrdersDiary {
    /*
    * moveid int primary key auto_increment,
    movetime datetime default now(),
    movecount varchar(400),
    movestatus tinyint,
    movepeople varchar(256)
    * */
    private int moveid;
    private String movetime;
    private int movecount;
    private int movestatus;
    private String movepeople;

    public HistoryOrdersDiary() {
    }

    public HistoryOrdersDiary(int moveid, String movetime, int movecount, int movestatus, String movepeople) {
        this.moveid = moveid;
        this.movetime = movetime;
        this.movecount = movecount;
        this.movestatus = movestatus;
        this.movepeople = movepeople;
    }

    @Override
    public String toString() {
        return "HistoryOrdersDiary{" +
                "moveid=" + moveid +
                ", movetime='" + movetime + '\'' +
                ", movecount=" + movecount +
                ", movestatus=" + movestatus +
                ", movepeople='" + movepeople + '\'' +
                '}';
    }

    public int getMoveid() {
        return moveid;
    }

    public void setMoveid(int moveid) {
        this.moveid = moveid;
    }

    public String getMovetime() {
        return movetime;
    }

    public void setMovetime(String movetime) {
        this.movetime = movetime;
    }

    public int getMovecount() {
        return movecount;
    }

    public void setMovecount(int movecount) {
        this.movecount = movecount;
    }

    public int getMovestatus() {
        return movestatus;
    }

    public void setMovestatus(int movestatus) {
        this.movestatus = movestatus;
    }

    public String getMovepeople() {
        return movepeople;
    }

    public void setMovepeople(String movepeople) {
        this.movepeople = movepeople;
    }
}
