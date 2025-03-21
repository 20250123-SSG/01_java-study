package com.sotogito.coffeeshop.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final HashMap<Product, Integer> orders = new HashMap<>();
    private int purchaseAmount = 0;

    /// else를 잘 활용한 케이스 둘다 의미있는 행위이며 동통되는 처리를 할 수 있음
    public void addCart(Product product) {
        if (orders.containsKey(product)) {
            orders.put(product, orders.get(product) + 1);
        }else {
            orders.put(product, 1);
        }
        purchaseAmount += product.getPrice();
    }

    public Map<Product, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }

    public int calculateBalance(int userAmount) {
        return userAmount - purchaseAmount;
    }

    public void clear(){
        orders.clear();
        purchaseAmount = 0;
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

}
