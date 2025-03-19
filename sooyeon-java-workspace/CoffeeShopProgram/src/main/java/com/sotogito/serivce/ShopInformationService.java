package com.sotogito.serivce;

import com.sotogito.coffeeshop.model.Shop;

public class ShopInformationService {
    private final Shop shop;

    public ShopInformationService(Shop shop) {
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
