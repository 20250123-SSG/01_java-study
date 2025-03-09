package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.ProductType;
import com.sotogito.coffeeshop.exception.ProductInformationUpdateException;

import java.util.Objects;

public class Coffee implements Product {
    private final String name;
    private final int price;

    public Coffee(String name, int price) {
        if(name == null) throw new ProductInformationUpdateException("이름이 비어있습니다.");
        if(price < 0) throw new ProductInformationUpdateException("가격은 최소 0원으로 등록해주세요.");

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(name, coffee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
