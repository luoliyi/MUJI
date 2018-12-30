package com.nf.entities;

public class OrdersMap {
    private String cono;
    private String mphone;
    private String corderDate;
    private String cordesc;
    private int coinvoice;
    private int costatus;
    private int paystatus;
    private double osumprice;

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getCorderDate() {
        return corderDate;
    }

    public void setCorderDate(String corderDate) {
        this.corderDate = corderDate;
    }

    public String getCordesc() {
        return cordesc;
    }

    public void setCordesc(String cordesc) {
        this.cordesc = cordesc;
    }

    public int getCoinvoice() {
        return coinvoice;
    }

    public void setCoinvoice(int coinvoice) {
        this.coinvoice = coinvoice;
    }

    public int getCostatus() {
        return costatus;
    }

    public void setCostatus(int costatus) {
        this.costatus = costatus;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public double getOsumprice() {
        return osumprice;
    }

    public void setOsumprice(double osumprice) {
        this.osumprice = osumprice;
    }

    public OrdersMap() {
    }

    public OrdersMap(String cono, String mphone, String corderDate, String cordesc, int coinvoice, int costatus, int paystatus, double osumprice) {
        this.cono = cono;
        this.mphone = mphone;
        this.corderDate = corderDate;
        this.cordesc = cordesc;
        this.coinvoice = coinvoice;
        this.costatus = costatus;
        this.paystatus = paystatus;
        this.osumprice = osumprice;
    }

    @Override
    public String toString() {
        return "OrdersMap{" +
                "cono='" + cono + '\'' +
                ", mphone='" + mphone + '\'' +
                ", corderDate='" + corderDate + '\'' +
                ", cordesc='" + cordesc + '\'' +
                ", coinvoice=" + coinvoice +
                ", costatus=" + costatus +
                ", paystatus=" + paystatus +
                ", osumprice=" + osumprice +
                '}';
    }
}
