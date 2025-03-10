package com.sotogito.coffeeshop.controller2;

import com.sotogito.coffeeshop.dao.ShopInformationManager;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.Shop;

public class ShopInformationController {
    private final ShopInformationManager shopInformationManager;

    public ShopInformationController(ShopInformationManager shopInformationManager) {
        this.shopInformationManager = shopInformationManager;
    }

    public Shop getShop() {
        return shopInformationManager.getShop();
    }

    public Shop getOriginShop(){
        return shopInformationManager.getOriginalShop();
    }

    public void editShopName(String newName) {
        shopInformationManager.editShopName(newName);
    }

    public void editShopAddress(String newAddress) {
        shopInformationManager.editShopAddress(newAddress);
    }

    public void editShopMasterId(int newMasterId) {
        shopInformationManager.editShopMasterId(newMasterId);
    }

}
