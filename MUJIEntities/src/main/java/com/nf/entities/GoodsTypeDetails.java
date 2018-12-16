package com.nf.entities;

import java.util.List;

public class GoodsTypeDetails {
    /*
    *
    *    gtdid int primary key auto_increment,
    gtdname varchar(30) not null,
    tid int references GoodsType(tid),
    tdesc varchar(256)
    * */

    private int gtdid;
    private String gtdname;
    private int tid;
    private String tdesc;

    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public GoodsTypeDetails() {
    }

    public GoodsTypeDetails(String gtname, int tid, String tdesc) {
        this.gtdname = gtname;
        this.tid = tid;
        this.tdesc = tdesc;
    }

    public GoodsTypeDetails(int gtdid, String gtname, int tid, String tdesc) {
        this.gtdid = gtdid;
        this.gtdname = gtname;
        this.tid = tid;
        this.tdesc = tdesc;
    }

    @Override
    public String toString() {
        return "GoodsTypeDetails{" +
                "gtdid=" + gtdid +
                ", gtdname='" + gtdname + '\'' +
                ", tid=" + tid +
                ", tdesc='" + tdesc + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }

    public int getGtdid() {
        return gtdid;
    }

    public void setGtdid(int gtdid) {
        this.gtdid = gtdid;
    }

    public String getGtdname() {
        return gtdname;
    }

    public void setGtdname(String gtname) {
        this.gtdname = gtname;
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
