package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.ProductType;

public interface Product {

    String getName();

    int getPrice();

    ProductType getType();
}
