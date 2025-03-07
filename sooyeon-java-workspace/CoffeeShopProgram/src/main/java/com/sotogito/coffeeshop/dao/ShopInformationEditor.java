package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.model.Shop;

public class ShopInformationEditor {
    private final Shop shop;

    public ShopInformationEditor(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
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
