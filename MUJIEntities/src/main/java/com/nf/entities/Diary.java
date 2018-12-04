package com.nf.entities;

import java.util.Date;

public class Diary {
    /*
    *	dayid int primary key auto_increment,
    daytname varchar(100),
    daypath varchar(200),
    daytime datetime default now()
    * */
    private int dayid;
    private String daytname;
    private String daypath;
    private Date daytime;

    public Diary() {
    }

    @Override
    public String toString() {
        return "Diary{" +
                "dayid=" + dayid +
                ", daytname='" + daytname + '\'' +
                ", daypath='" + daypath + '\'' +
                ", daytime=" + daytime +
                '}';
    }

    public int getDayid() {
        return dayid;
    }

    public void setDayid(int dayid) {
        this.dayid = dayid;
    }

    public String getDaytname() {
        return daytname;
    }

    public void setDaytname(String daytname) {
        this.daytname = daytname;
    }

    public String getDaypath() {
        return daypath;
    }

    public void setDaypath(String daypath) {
        this.daypath = daypath;
    }

    public Date getDaytime() {
        return daytime;
    }

    public void setDaytime(Date daytime) {
        this.daytime = daytime;
    }

    public Diary(String daytname, String daypath, Date daytime) {
        this.daytname = daytname;
        this.daypath = daypath;
        this.daytime = daytime;
    }

    public Diary(int dayid, String daytname, String daypath, Date daytime) {
        this.dayid = dayid;
        this.daytname = daytname;
        this.daypath = daypath;
        this.daytime = daytime;
    }
}
