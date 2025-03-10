package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.model.Shop;

public class ShopInformationManager {
    private final Shop shop;

    public ShopInformationManager(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public Shop getOriginalShop() {
        return shop.getOriginalShopContainInfo();
    }

    public void editShopName(String newName) {
        shop.setName(newName);
    }

    public void editShopAddress(String newAddress) {
        shop.setAddress(newAddress);
    }

    public void editShopMasterId(int newMasterId) {
        shop.setMasterId(newMasterId);
    }

}
