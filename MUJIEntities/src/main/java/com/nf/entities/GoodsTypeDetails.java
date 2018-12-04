package com.nf.entities;

public class GoodsTypeDetails {
    /*
    *
    *    gtdid int primary key auto_increment,
    gtdname varchar(30) not null,
    tid int references GoodsType(tid),
    tdesc varchar(256)
    * */

    private int gtdid;
    private String gtname;
    private int tid;
    private String tdesc;

    public GoodsTypeDetails() {
    }

    public GoodsTypeDetails(String gtname, int tid, String tdesc) {
        this.gtname = gtname;
        this.tid = tid;
        this.tdesc = tdesc;
    }

    public GoodsTypeDetails(int gtdid, String gtname, int tid, String tdesc) {
        this.gtdid = gtdid;
        this.gtname = gtname;
        this.tid = tid;
        this.tdesc = tdesc;
    }

    @Override
    public String toString() {
        return "GoodsTypeDetails{" +
                "gtdid=" + gtdid +
                ", gtname='" + gtname + '\'' +
                ", tid=" + tid +
                ", tdesc='" + tdesc + '\'' +
                '}';
    }

    public int getGtdid() {
        return gtdid;
    }

    public void setGtdid(int gtdid) {
        this.gtdid = gtdid;
    }

    public String getGtname() {
        return gtname;
    }

    public void setGtname(String gtname) {
        this.gtname = gtname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTdesc() {
        return tdesc;
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }
}
