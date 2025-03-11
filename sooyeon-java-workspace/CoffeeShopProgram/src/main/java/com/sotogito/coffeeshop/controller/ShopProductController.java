package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.dao.ShopProductManager;
import com.sotogito.coffeeshop.model.Product;

import java.util.List;

public class ShopProductController {
    private final ShopProductManager shopProductManager;

    public ShopProductController(ShopProductManager shopProductManager) {
        this.shopProductManager = shopProductManager;
    }

    public void addNewProduct(Product product) {
        shopProductManager.addNewProduct(product);
    }

    public void deleteProduct(Product product) {

    }

    public List<Product> getCoffeeList() {
        return shopProductManager.getCoffeeList();
    }

    public List<Product> getBreadList() {
        return shopProductManager.getBreadList();
    }

}
