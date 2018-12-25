package com.nf.entities;

public class ShoppingCart {
    /*
    * 	scid int primary key auto_increment,
    mphone char(11) references member(mphone),
    gid int references Goods(gid),
    sccount int default 1,
    sumprice decimal(6,2) default 0,
    sctate bit default 0
    * */
    private int scid;
    private String mphone;
    private int gid;
    private int sccount;
    private  double sumprice;
    private int sctate;

    private Member member;
    private Goods goods;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public ShoppingCart() {
    }


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "scid=" + scid +
                ", mphone='" + mphone + '\'' +
                ", gid=" + gid +
                ", sccount=" + sccount +
                ", sumprice=" + sumprice +
                ", sctate=" + sctate +
                ", member=" + member +
                ", goods=" + goods +
                '}';
    }

    public ShoppingCart(String mphone, int gid, int sccount, double sumprice, int sctate) {
        this.mphone = mphone;
        this.gid = gid;
        this.sccount = sccount;
        this.sumprice = sumprice;
        this.sctate = sctate;
    }
    public ShoppingCart(String mphone, int gid, int sccount, double sumprice) {
        this.mphone = mphone;
        this.gid = gid;
        this.sccount = sccount;
        this.sumprice = sumprice;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
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

    public int getSccount() {
        return sccount;
    }

    public void setSccount(int sccount) {
        this.sccount = sccount;
    }

    public double getSumprice() {
        return sumprice;
    }

    public void setSumprice(double sumprice) {
        this.sumprice = sumprice;
    }

    public int getSctate() {
        return sctate;
    }

    public void setSctate(int sctate) {
        this.sctate = sctate;
    }

    public ShoppingCart(int scid, String mphone, int gid, int sccount, double sumprice, int sctate) {
        this.scid = scid;
        this.mphone = mphone;
        this.gid = gid;
        this.sccount = sccount;
        this.sumprice = sumprice;
        this.sctate = sctate;
    }
}
