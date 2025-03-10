package com.minkook.dto;

public class Snack {
    private String name;
    private String origin;
    private int price;

    public Snack() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Snack(String name, String origin, int price) {
        this.name = name;
        this.origin = origin;
        this.price = price;
    }


}