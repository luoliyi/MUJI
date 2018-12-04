package com.nf.entities;

public class Orders {
    /*
    *orderid int primary key auto_increment,
    mphone char(11) references member(mphone),
    gid int references Goods(gid),
    ocount int not null default 1,
    osumprice decimal(6,2)not null,
    cono varchar(60) references CreateOrders(cono),
    ostate bit default 0
    * */

    private int orderid;
    private String mphone;
    private int gid;
    private int ocount;
    private double osumprice;
    private String cono;
    private  int ostate;

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", mphone='" + mphone + '\'' +
                ", gid=" + gid +
                ", ocount=" + ocount +
                ", osumprice=" + osumprice +
                ", cono='" + cono + '\'' +
                ", ostate=" + ostate +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getOcount() {
        return ocount;
    }

    public void setOcount(int ocount) {
        this.ocount = ocount;
    }

    public double getOsumprice() {
        return osumprice;
    }

    public void setOsumprice(double osumprice) {
        this.osumprice = osumprice;
    }

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }

    public Orders() {
    }

    public Orders(String mphone, int gid, int ocount, double osumprice, String cono, int ostate) {
        this.mphone = mphone;
        this.gid = gid;
        this.ocount = ocount;
        this.osumprice = osumprice;
        this.cono = cono;
        this.ostate = ostate;
    }

    public Orders(int orderid, String mphone, int gid, int ocount, double osumprice, String cono, int ostate) {
        this.orderid = orderid;
        this.mphone = mphone;
        this.gid = gid;
        this.ocount = ocount;
        this.osumprice = osumprice;
        this.cono = cono;
        this.ostate = ostate;
    }
}
