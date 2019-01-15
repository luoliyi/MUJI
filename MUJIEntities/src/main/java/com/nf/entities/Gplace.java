package com.nf.entities;

public class Gplace {

    /*
    * Gplaceid int primary key auto_increment,
    gplacelocation varchar(256) not null,
    gplacephone varchar(20) not null

    * */
    private int gplaceid;
    private String gplacelocation;
    private String gplacephone;

    public Gplace(int gplaceid, String gplacelocation, String gplacephone) {
        this.gplaceid = gplaceid;
        this.gplacelocation = gplacelocation;
        this.gplacephone = gplacephone;
    }

    public Gplace(String gplacelocation, String gplacephone) {
        this.gplacelocation = gplacelocation;
        this.gplacephone = gplacephone;
    }

    public Gplace() {
    }

    @Override
    public String toString() {
        return "Gplace{" +
                "gplaceid=" + gplaceid +
                ", gplacelocation='" + gplacelocation + '\'' +
                ", gplacephone='" + gplacephone + '\'' +
                '}';
    }

    public int getGplaceid() {
        return gplaceid;
    }

    public void setGplaceid(int gplaceid) {
        this.gplaceid = gplaceid;
    }

    public String getGplacelocation() {
        return gplacelocation;
    }

    public void setGplacelocation(String gplacelocation) {
        this.gplacelocation = gplacelocation;
    }

    public String getGplacephone() {
        return gplacephone;
    }

    public void setGplacephone(String gplacephone) {
        this.gplacephone = gplacephone;
    }
}
