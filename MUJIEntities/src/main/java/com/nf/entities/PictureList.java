package com.nf.entities;

public class PictureList {
    private int picid;
    private String picpath;
    private String picdesc;
    private int gid;

    public PictureList() {
    }

    public PictureList(String picpath, String picdesc, int gid) {
        this.picpath = picpath;
        this.picdesc = picdesc;
        this.gid = gid;
    }

    public PictureList(int picid, String picpath, String picdesc, int gid) {
        this.picid = picid;
        this.picpath = picpath;
        this.picdesc = picdesc;
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "PictureList{" +
                "picid=" + picid +
                ", picpath='" + picpath + '\'' +
                ", picdesc='" + picdesc + '\'' +
                ", gid=" + gid +
                '}';
    }

    public int getPicid() {
        return picid;
    }

    public void setPicid(int picid) {
        this.picid = picid;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getPicdesc() {
        return picdesc;
    }

    public void setPicdesc(String picdesc) {
        this.picdesc = picdesc;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
