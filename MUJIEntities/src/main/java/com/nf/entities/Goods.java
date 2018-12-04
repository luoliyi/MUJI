package com.nf.entities;

public class Goods {
    /*
    *     gid int primary key auto_increment,
    gno varchar(100) not null,
    gname varchar(30) not null,
    gcolor varchar(100), ##颜色
	gsize varchar(100),  ##尺码
    gpic text,
    gnowprice decimal(6,2) not null,
    gprevPrice decimal(6,2),
    gdesc varchar(256),
    gstate bit default 0,
    tid int references GoodsType(tid), ##大类型
    gtdid int references GoodsTypeDetails(gtdid) ##详细类型
    * */

    private int gid;
    private String gno;
    private String gname;
    private String gcolor;
    private String gsize;
    private String gpic;
    private double gnowprice;
    private double gprevPrice;
    private String gdesc;
    private int gstate;
    private int tid;
    private int gtdid;

    private GoodsTypeDetails goodsTypeDetails;
    private GoodsType goodsType;

    public GoodsTypeDetails getGoodsTypeDetails() {
        return goodsTypeDetails;
    }

    public void setGoodsTypeDetails(GoodsTypeDetails goodsTypeDetails) {
        this.goodsTypeDetails = goodsTypeDetails;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gno='" + gno + '\'' +
                ", gname='" + gname + '\'' +
                ", gcolor='" + gcolor + '\'' +
                ", gsize='" + gsize + '\'' +
                ", gpic='" + gpic + '\'' +
                ", gnowprice=" + gnowprice +
                ", gprevPrice=" + gprevPrice +
                ", gdesc='" + gdesc + '\'' +
                ", gstate=" + gstate +
                ", tid=" + tid +
                ", gtdid=" + gtdid +
                ", goodsTypeDetails=" + goodsTypeDetails +
                ", goodsType=" + goodsType +
                '}';
    }

    public Goods(String gno, String gname, String gcolor, String gsize, String gpic, double gnowprice, double gprevPrice, String gdesc, int gstate, int tid, int gtdid) {
        this.gno = gno;
        this.gname = gname;
        this.gcolor = gcolor;
        this.gsize = gsize;
        this.gpic = gpic;
        this.gnowprice = gnowprice;
        this.gprevPrice = gprevPrice;
        this.gdesc = gdesc;
        this.gstate = gstate;
        this.tid = tid;
        this.gtdid = gtdid;
    }

    public Goods() {
    }

    public Goods(int gid, String gno, String gname, String gcolor, String gsize, String gpic, double gnowprice, double gprevPrice, String gdesc, int gstate, int tid, int gtdid) {
        this.gid = gid;
        this.gno = gno;
        this.gname = gname;
        this.gcolor = gcolor;
        this.gsize = gsize;
        this.gpic = gpic;
        this.gnowprice = gnowprice;
        this.gprevPrice = gprevPrice;
        this.gdesc = gdesc;
        this.gstate = gstate;
        this.tid = tid;
        this.gtdid = gtdid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGcolor() {
        return gcolor;
    }

    public void setGcolor(String gcolor) {
        this.gcolor = gcolor;
    }

    public String getGsize() {
        return gsize;
    }

    public void setGsize(String gsize) {
        this.gsize = gsize;
    }

    public String getGpic() {
        return gpic;
    }

    public void setGpic(String gpic) {
        this.gpic = gpic;
    }

    public double getGnowprice() {
        return gnowprice;
    }

    public void setGnowprice(double gnowprice) {
        this.gnowprice = gnowprice;
    }

    public double getGprevPrice() {
        return gprevPrice;
    }

    public void setGprevPrice(double gprevPrice) {
        this.gprevPrice = gprevPrice;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public int getGstate() {
        return gstate;
    }

    public void setGstate(int gstate) {
        this.gstate = gstate;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getGtdid() {
        return gtdid;
    }

    public void setGtdid(int gtdid) {
        this.gtdid = gtdid;
    }
}
