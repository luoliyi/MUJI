package com.nf.entities;

import java.util.Date;

public class Member {
    /*
    *     mid int primary key auto_increment,
        mphone char(11) not null,
        mpassword varchar(20) not null,
        mname varchar(20),
        Mbirthday date,
        msex varchar(5) default'男',
        mlocation varchar(256),
        mpic Text,
        mstate bit default 0
    * */
    private int mid;
    private String mphone;
    private String mpassword;
    private String mname;
    private Date Mbirthday;
    private Date mregdate;
    private String msex;
    private String mlocation;
    private String mpic;
    private int mstate;

    public Member() {
    }

    public Date getMregdate() {
        return mregdate;
    }

    public void setMregdate(Date mregdate) {
        this.mregdate = mregdate;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Date getMbirthday() {
        return Mbirthday;
    }

    public void setMbirthday(Date mbirthday) {
        Mbirthday = mbirthday;
    }

    public String getMsex() {
        return msex;
    }

    public void setMsex(String msex) {
        this.msex = msex;
    }

    public String getMlocation() {
        return mlocation;
    }

    public void setMlocation(String mlocation) {
        this.mlocation = mlocation;
    }

    public String getMpic() {
        return mpic;
    }

    public void setMpic(String mpic) {
        this.mpic = mpic;
    }

    public int getMstate() {
        return mstate;
    }

    public void setMstate(int mstate) {
        this.mstate = mstate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid=" + mid +
                ", mphone='" + mphone + '\'' +
                ", mpassword='" + mpassword + '\'' +
                ", mname='" + mname + '\'' +
                ", Mbirthday=" + Mbirthday +
                ", mregdate=" + mregdate.toLocaleString() +
                ", msex='" + msex + '\'' +
                ", mlocation='" + mlocation + '\'' +
                ", mpic='" + mpic + '\'' +
                ", mstate=" + mstate +
                '}';
    }

    public Member(String mphone, String mpassowrd, String mname, Date mbirthday, Date mregdate, String msex, String mlocation, String mpic, int mstate) {
        this.mphone = mphone;
        this.mpassword = mpassowrd;
        this.mname = mname;
        Mbirthday = mbirthday;
        this.mregdate = mregdate;
        this.msex = msex;
        this.mlocation = mlocation;
        this.mpic = mpic;
        this.mstate = mstate;
    }

    public Member(int mid, String mphone, String mpassowrd, String mname, Date mbirthday, Date mregdate, String msex, String mlocation, String mpic, int mstate) {
        this.mid = mid;
        this.mphone = mphone;
        this.mpassword = mpassowrd;
        this.mname = mname;
        Mbirthday = mbirthday;
        this.mregdate = mregdate;
        this.msex = msex;
        this.mlocation = mlocation;
        this.mpic = mpic;
        this.mstate = mstate;
    }
}
