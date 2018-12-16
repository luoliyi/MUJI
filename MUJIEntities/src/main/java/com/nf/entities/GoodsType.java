package com.nf.entities;

import java.util.List;

public class GoodsType {
    /*
    * 	tid int primary key auto_increment,
    tname varchar(30) not null,
	tdesc varchar(256)
    * */

    private int tid;
    private String tname;
    private String tdesc;

    private List<GoodsTypeDetails> goodsTypeDetailsList;

    public List<GoodsTypeDetails> getGoodsTypeDetails() {
        return goodsTypeDetailsList;
    }

    public void setGoodsTypeDetails(List<GoodsTypeDetails> goodsTypeDetails) {
        this.goodsTypeDetailsList = goodsTypeDetails;
    }

    public GoodsType(int tid, String tname, String tdesc) {
        this.tid = tid;
        this.tname = tname;
        this.tdesc = tdesc;
    }

    public GoodsType(String tname, String tdesc) {
        this.tname = tname;
        this.tdesc = tdesc;
    }

    public GoodsType() {
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tdesc='" + tdesc + '\'' +
                ", goodsTypeDetailsList=" + goodsTypeDetailsList +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTdesc() {
        return tdesc;
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }
}
