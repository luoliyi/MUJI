package com.nf.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

public class Administrator {

    /*
    * 	aid int primary key auto_increment,
    aphone char(11) not null,
    apassword varchar(20)not null,
    apic text not null,
    adesc varchar(256),
    astate bit default 0
    * */
    private int aid;
    private String aphone;
    private String aname;
    private String adept;
    private String apassword;
    private String apic;
    private String adesc;
    private String aregday;
    private int astate;

    public Administrator() {
    }

    public Administrator(String aphone, String aname, String adept, String apassword, String apic, String adesc, String aregday, int astate) {
        this.aphone = aphone;
        this.aname = aname;
        this.adept = adept;
        this.apassword = apassword;
        this.apic = apic;
        this.adesc = adesc;
        this.aregday = aregday;
        this.astate = astate;
    }

    public Administrator(int aid, String aphone, String aname, String adept, String apassword, String apic, String adesc, String aregday, int astate) {
        this.aid = aid;
        this.aphone = aphone;
        this.aname = aname;
        this.adept = adept;
        this.apassword = apassword;
        this.apic = apic;
        this.adesc = adesc;
        this.aregday = aregday;
        this.astate = astate;
    }

    public String getAdept() {
        return adept;
    }

    public void setAdept(String adept) {
        this.adept = adept;
    }

    public String getAregday() {
        return aregday;
    }

    public void setAregday(String aregday) {
        this.aregday = aregday;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public String getApic() {
        return apic;
    }

    public void setApic(String apic) {
        this.apic = apic;
    }

    public String getAdesc() {
        return adesc;
    }

    public void setAdesc(String adesc) {
        this.adesc = adesc;
    }

    public int getAstate() {
        return astate;
    }

    public void setAstate(int astate) {
        this.astate = astate;
    }


    @Override
    public String toString() {
        return "Administrator{" +
                "aid=" + aid +
                ", aphone='" + aphone + '\'' +
                ", aname='" + aname + '\'' +
                ", adept='" + adept + '\'' +
                ", apassword='" + apassword + '\'' +
                ", apic='" + apic + '\'' +
                ", adesc='" + adesc + '\'' +
                ", aregday=" + aregday +
                ", astate=" + astate +
                '}';
    }
}
