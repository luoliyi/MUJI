package com.nf.entities;

import java.util.List;

public class Sales {
    private int saleMonth;
    private int saleCount;
    private double saleSumprice;

    public int getSaleMonth() {
        return saleMonth;
    }

    public void setSaleMonth(int saleMonth) {
        this.saleMonth = saleMonth;
    }

    private List<Sales> salesList;

    private Sales() {
    }

    public Sales(double saleSumprice) {
        this.saleSumprice = saleSumprice;
    }

    ;

    public Sales(int saleMonth, double saleSumprice) {
        this.saleMonth = saleMonth;
        this.saleSumprice = saleSumprice;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleMonth) {
        this.saleCount = saleMonth;
    }

    public double getSaleSumprice() {
        return saleSumprice;
    }

    public void setSaleSumprice(double saleSumprice) {
        this.saleSumprice = saleSumprice;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "saleMonth=" + saleMonth +
                ", saleCount=" + saleCount +
                ", saleSumprice=" + saleSumprice +
                '}';
    }
}
