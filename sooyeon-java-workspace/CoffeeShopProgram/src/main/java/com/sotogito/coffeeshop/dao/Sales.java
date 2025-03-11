package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.model.Product;

import java.util.HashMap;
import java.util.Map;

public enum Sales {
    SALES;

    private final static String PRINT_SALES_HISTORY_FORMAT = "%s : %,d개\n";
    public final static String PRINT_TOTAL_SALES_AMOUNT = "총 판매액 : %,d\n";

    private final static HashMap<Product, Integer> sales = new HashMap<>();

    public void add(Product product) {
        if (sales.containsKey(product)) {
            sales.put(product, sales.get(product) + 1);
            return;
        }
        sales.put(product, 1);
    }

    public int getTotalSalesAmount() {
        return sales.keySet().stream()
                .mapToInt(product -> product.getPrice() * sales.get(product))
                .sum();
    }


    @Override
    public String toString() {
        if (sales.isEmpty()) return "없음";

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Product, Integer> entry : sales.entrySet()) {
            Product product = entry.getKey();
            int count = entry.getValue();

            sb.append(String.format(PRINT_SALES_HISTORY_FORMAT, product, count));
        }
        return sb.toString().trim();
    }

}
