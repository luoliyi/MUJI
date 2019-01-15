package com.nf.entities;

public class Evaluate {
    /*
    *	eid int primary key auto_increment,
	cono varchar(60) references CreateOrders(cono),
    eminute tinyint default 1,  ##打分
    edesc varchar(256)
    * */

    private int eid;
    private String cono;
    private int eminute;
    private String edesc;

    public Evaluate() {
    }

    public Evaluate(String cono, int eminute, String edesc) {
        this.cono = cono;
        this.eminute = eminute;
        this.edesc = edesc;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "eid=" + eid +
                ", cono='" + cono + '\'' +
                ", eminute=" + eminute +
                ", edesc='" + edesc + '\'' +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public int getEminute() {
        return eminute;
    }

    public void setEminute(int eminute) {
        this.eminute = eminute;
    }

    public String getEdesc() {
        return edesc;
    }

    public void setEdesc(String edesc) {
        this.edesc = edesc;
    }

    public Evaluate(int eid, String cono, int eminute, String edesc) {
        this.eid = eid;
        this.cono = cono;
        this.eminute = eminute;
        this.edesc = edesc;
    }
}
