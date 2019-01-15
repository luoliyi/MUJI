package com.nf.entities;

public class Cost {
    /*
    * 	costid int primary key auto_increment,
    costprice decimal(6,2) not null,
    costdesc varchar(256),
    gplaceid int references Gplace(Gplaceid)
    *
    * */

    private int costid;
    private Double costprice;
    private String costdesc;
    private int gplaceid;

    public Cost() {
    }

    @Override
    public String toString() {
        return "Cost{" +
                "costid=" + costid +
                ", costprice=" + costprice +
                ", costdesc='" + costdesc + '\'' +
                ", gplaceid=" + gplaceid +
                '}';
    }

    public int getCostid() {
        return costid;
    }

    public void setCostid(int costid) {
        this.costid = costid;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public String getCostdesc() {
        return costdesc;
    }

    public void setCostdesc(String costdesc) {
        this.costdesc = costdesc;
    }

    public int getGplaceid() {
        return gplaceid;
    }

    public void setGplaceid(int gplaceid) {
        this.gplaceid = gplaceid;
    }

    public Cost(Double costprice, String costdesc, int gplaceid) {
        this.costprice = costprice;
        this.costdesc = costdesc;
        this.gplaceid = gplaceid;
    }

    public Cost(int costid, Double costprice, String costdesc, int gplaceid) {
        this.costid = costid;
        this.costprice = costprice;
        this.costdesc = costdesc;
        this.gplaceid = gplaceid;
    }
}
