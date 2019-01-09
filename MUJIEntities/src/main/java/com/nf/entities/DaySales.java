package com.nf.entities;

import java.util.List;

public class DaySales {
    private String gname;
    private String osumprice;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getOsumprice() {
        return osumprice;
    }

    public void setOsumprice(String osumprice) {
        this.osumprice = osumprice;
    }


    @Override
    public String toString() {
        return "DaySales{" +
                "gname='" + gname + '\'' +
                ", osumprice='" + osumprice + '\'' +
                '}';
    }

    public DaySales(){}
    public DaySales(String gname, String osumprice) {
        this.gname = gname;
        this.osumprice = osumprice;
    }
}
