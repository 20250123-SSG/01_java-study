package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.ProductType;

import java.util.Objects;

public class Coffee implements Product {
    private final String name;
    private final int price;

    public Coffee(String name, int price) {
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
        return ProductType.COFFEE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return price == coffee.price && Objects.equals(name, coffee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
