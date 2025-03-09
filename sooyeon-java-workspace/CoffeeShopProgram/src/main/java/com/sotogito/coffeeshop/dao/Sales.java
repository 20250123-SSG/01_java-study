package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.model.Product;

import java.util.HashMap;

public enum Sales {
    SALES;

    private final static HashMap<Product, Integer> sales = new HashMap<>();

    public void add(Product product) {
        if (sales.containsKey(product)) {
            sales.put(product, sales.get(product) + 1);
            return;
        }
        sales.put(product, 1);
    }

    @Override
    public String toString() {
        if (sales.isEmpty()) return "없음";

        return "SalesRepository{" +
                "sales=" + sales +
                '}';
    }

}
