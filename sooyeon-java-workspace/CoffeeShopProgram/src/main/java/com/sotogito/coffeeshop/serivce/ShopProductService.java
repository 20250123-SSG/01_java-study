package com.sotogito.coffeeshop.serivce;

import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.Shop;

import java.util.List;

public class ShopProductService {
    private final Shop shop;

    public ShopProductService(Shop shop) {
        this.shop = shop;
    }

    public void addNewProduct(Product product) {
        shop.addProduct(product);
    }

    public void deleteProductByName(String productName) {
        shop.removeProduct(shop.findProductByName(productName));
    }


    public Product findProductByName(String name) {
        return shop.findProductByName(name);
    }

    public List<Product> getCoffeeList() {
        return shop.getCoffees();
    }

    public List<Product> getBreadList() {
        return shop.getBreads();
    }

}
