package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.ProductType;

import java.util.Objects;

public class Bread implements Product{
    private final String name;
    private final int price;

    public Bread(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public ProductType getType() {
        return ProductType.BREAD;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bread bread = (Bread) o;
        return price == bread.price && Objects.equals(name, bread.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Bread{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
