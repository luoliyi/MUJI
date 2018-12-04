package com.nf.entities;

import java.util.Date;

public class Diary {
    /*
    *		dayid int primary key auto_increment,
    daybftime datetime default now(),
    daypath varchar(200),
    dayhytime datetime default now(),
    daydesc varchar(256)
    * */
    private int dayid;
    private String daybftime;
    private String daypath;
    private String dayhytime;
    private String daydesc;

    public Diary() {
    }

    @Override
    public String toString() {
        return "Diary{" +
                "dayid=" + dayid +
                ", daybftime=" + daybftime +
                ", daypath='" + daypath + '\'' +
                ", dayhytime=" + dayhytime +
                ", daydesc='" + daydesc + '\'' +
                '}';
    }

    public int getDayid() {
        return dayid;
    }

    public void setDayid(int dayid) {
        this.dayid = dayid;
    }

    public String getDaybftime() {
        return daybftime;
    }

    public void setDaybftime(String daybftime) {
        this.daybftime = daybftime;
    }

    public String getDaypath() {
        return daypath;
    }

    public void setDaypath(String daypath) {
        this.daypath = daypath;
    }

    public String getDayhytime() {
        return dayhytime;
    }

    public void setDayhytime(String dayhytime) {
        this.dayhytime = dayhytime;
    }

    public String getDaydesc() {
        return daydesc;
    }

    public void setDaydesc(String daydesc) {
        this.daydesc = daydesc;
    }

    public Diary(String daybftime, String daypath, String dayhytime, String daydesc) {
        this.daybftime = daybftime;
        this.daypath = daypath;
        this.dayhytime = dayhytime;
        this.daydesc = daydesc;
    }

    public Diary(int dayid, String daybftime, String daypath, String dayhytime, String daydesc) {
        this.dayid = dayid;
        this.daybftime = daybftime;
        this.daypath = daypath;
        this.dayhytime = dayhytime;
        this.daydesc = daydesc;
    }
}
