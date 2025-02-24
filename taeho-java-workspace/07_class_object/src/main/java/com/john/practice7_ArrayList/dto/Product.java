package com.john.practice7_ArrayList.dto;

public class Product {
    private int pid;
    private String pName;
    private int price;
    private double tax;

    public Product() {}

    public Product(int pid, String pName, int price, double tax) {
        this.pid = pid;
        this.pName = pName;
        this.price = price;
        this.tax = tax;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return pName;
    }

    public void setName(String pName) {
        this.pName = pName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getInformation() {
        return "제품번호: " + pid + "\n"
                + "제품명: " + pName + "\n"
                + "제품 가격: " + price + "\n"
                + "제품 세율: " + tax;
    }
}