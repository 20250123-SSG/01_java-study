package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.serivce.ShopProductService;
import com.sotogito.coffeeshop.model.Product;

import java.util.List;

public class ShopProductController {
    private final ShopProductService shopProductManager;

    public ShopProductController(ShopProductService shopProductManager) {
        this.shopProductManager = shopProductManager;
    }


    public void addNewProduct(Product product) {
        shopProductManager.addNewProduct(product);
    }

    public void deleteProductByName(String productName) {
        shopProductManager.deleteProductByName(productName);
    }


    public List<Product> getCoffeeList() {
        return shopProductManager.getCoffeeList();
    }

    public List<Product> getBreadList() {
        return shopProductManager.getBreadList();
    }

}
