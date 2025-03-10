package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.dao.ShopInformationManager;
import com.sotogito.coffeeshop.dao.ShopProductManager;
import com.sotogito.coffeeshop.dao.ShopSalesFileMaker;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.Shop;

public class AdministratorController {
    private final ShopInformationManager shopInformationManager;
    private final ShopProductManager shopProductManager;
    private final ShopSalesFileMaker shopSalesManagement;

    public AdministratorController(ShopInformationManager shopInformationManager, ShopProductManager shopProductManager, ShopSalesFileMaker shopSalesManagement) {
        this.shopInformationManager = shopInformationManager;
        this.shopProductManager = shopProductManager;
        this.shopSalesManagement = shopSalesManagement;
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

    public void addNewProduct(Product product) {
        shopProductManager.addNewProduct(product);
    }

}
