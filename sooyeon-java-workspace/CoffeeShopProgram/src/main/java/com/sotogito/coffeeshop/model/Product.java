package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.ProductType;

import java.io.Serializable;

public interface Product extends Serializable {

    String getName();

    int getPrice();

    ProductType getType();

}
