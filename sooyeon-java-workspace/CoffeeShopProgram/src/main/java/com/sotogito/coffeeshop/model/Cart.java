package com.sotogito.coffeeshop.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final HashMap<Product, Integer> orders = new HashMap<>();

    public void addOrder(Product product) {
        if (orders.containsKey(product)) {
            orders.put(product, orders.get(product) + 1);
            return;
        }
        orders.put(product, 1);
    }

    public Map<Product, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }

}
