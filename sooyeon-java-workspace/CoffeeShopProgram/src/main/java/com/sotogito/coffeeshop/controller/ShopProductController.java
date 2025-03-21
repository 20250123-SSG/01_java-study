package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.serivce.ShopProductService;
import com.sotogito.coffeeshop.model.Product;

import java.util.List;

public class ShopProductController {
    private final ShopProductService shopProductService;

    public ShopProductController(ShopProductService shopProductManager) {
        this.shopProductService = shopProductManager;
    }


    public void addNewProduct(Product product) {
        shopProductService.addNewProduct(product);
    }

    public void deleteProductByName(String productName) {
        shopProductService.deleteProductByName(productName);
    }

    public List<Product> getCoffeeList() {
        return shopProductService.getCoffeeList();
    }

    public List<Product> getBreadList() {
        return shopProductService.getBreadList();
    }

}
