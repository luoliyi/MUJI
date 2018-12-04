package com.nf.entities;

import java.util.Date;

public class CreateOrders {

    /*
    *  cono varchar(60) primary key,
	   datetime default now(),
	 coinvoice bit default 0,  ##发票
	 cordesc varchar(256),
	 costatus bit default 0
    * */

    private String cono;
    private Date corderDate;
    private int coinvoice;
    private String cordesc;
    private int costatus;

    @Override
    public String toString() {
        return "CreateOrders{" +
                "cono='" + cono + '\'' +
                ", corderDate=" + corderDate +
                ", coinvoice=" + coinvoice +
                ", cordesc='" + cordesc + '\'' +
                ", costatus=" + costatus +
                '}';
    }

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public Date getCorderDate() {
        return corderDate;
    }

    public void setCorderDate(Date corderDate) {
        this.corderDate = corderDate;
    }

    public int getCoinvoice() {
        return coinvoice;
    }

    public void setCoinvoice(int coinvoice) {
        this.coinvoice = coinvoice;
    }

    public String getCordesc() {
        return cordesc;
    }

    public void setCordesc(String cordesc) {
        this.cordesc = cordesc;
    }

    public int getCostatus() {
        return costatus;
    }

    public void setCostatus(int costatus) {
        this.costatus = costatus;
    }

    public CreateOrders(Date corderDate, int coinvoice, String cordesc, int costatus) {
        this.corderDate = corderDate;
        this.coinvoice = coinvoice;
        this.cordesc = cordesc;
        this.costatus = costatus;
    }

    public CreateOrders() {
    }

    public CreateOrders(String cono, Date corderDate, int coinvoice, String cordesc, int costatus) {
        this.cono = cono;
        this.corderDate = corderDate;
        this.coinvoice = coinvoice;
        this.cordesc = cordesc;
        this.costatus = costatus;
    }
}
