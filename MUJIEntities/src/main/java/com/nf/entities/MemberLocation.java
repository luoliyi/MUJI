package com.nf.entities;

public class MemberLocation {

    /*
    *      mlphone char(11) not null,
     mlname varchar(20),
     mlocation varchar(256),
     mldesc varchar(256) default'未填写备注信息',
     mid int references member(mid)
    * */

    private String mlphone;
    private String mlname;
    private String mlocation;
    private String mldesc;
    private int mid;

    public  MemberLocation(){

    }
    public MemberLocation(String mlphone, String mlname, String mlocation, String mldesc, int mid) {
        this.mlphone = mlphone;
        this.mlname = mlname;
        this.mlocation = mlocation;
        this.mldesc = mldesc;
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "MemberLocation{" +
                "mlphone='" + mlphone + '\'' +
                ", mlname='" + mlname + '\'' +
                ", mlocation='" + mlocation + '\'' +
                ", mldesc='" + mldesc + '\'' +
                ", mid=" + mid +
                '}';
    }

    public String getMlphone() {
        return mlphone;
    }

    public void setMlphone(String mlphone) {
        this.mlphone = mlphone;
    }

    public String getMlname() {
        return mlname;
    }

    public void setMlname(String mlname) {
        this.mlname = mlname;
    }

    public String getMlocation() {
        return mlocation;
    }

    public void setMlocation(String mlocation) {
        this.mlocation = mlocation;
    }

    public String getMldesc() {
        return mldesc;
    }

    public void setMldesc(String mldesc) {
        this.mldesc = mldesc;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
