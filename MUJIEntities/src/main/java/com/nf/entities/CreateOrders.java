package com.nf.entities;

import java.util.Date;
import java.util.List;

public class CreateOrders {

    /*
    *  cono varchar(60) primary key,
	   datetime default now(),
	 coinvoice bit default 0,  ##发票
	 cordesc varchar(256),
	 costatus bit default 0
    * */

    private String cono;
    private String corderDate;
    private int coinvoice;
    private String cordesc;
    private int costatus;
    private int paystatus;

    private Orders orders;

    private List<Orders> ordersList;

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }


    @Override
    public String toString() {
        return "CreateOrders{" +
                "cono='" + cono + '\'' +
                ", corderDate='" + corderDate + '\'' +
                ", coinvoice=" + coinvoice +
                ", cordesc='" + cordesc + '\'' +
                ", costatus=" + costatus +
                ", paystatus=" + paystatus +
                ", orders=" + orders +
                ", ordersList=" + ordersList +
                '}';
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public String getCorderDate() {
        return corderDate;
    }

    public void setCorderDate(String corderDate) {
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

    public CreateOrders(String corderDate, int coinvoice, String cordesc, int costatus) {
        this.corderDate = corderDate;
        this.coinvoice = coinvoice;
        this.cordesc = cordesc;
        this.costatus = costatus;
    }

    public CreateOrders() {
    }

    public CreateOrders(String cono, String corderDate, int coinvoice, String cordesc, int costatus) {
        this.cono = cono;
        this.corderDate = corderDate;
        this.coinvoice = coinvoice;
        this.cordesc = cordesc;
        this.costatus = costatus;
    }
}
