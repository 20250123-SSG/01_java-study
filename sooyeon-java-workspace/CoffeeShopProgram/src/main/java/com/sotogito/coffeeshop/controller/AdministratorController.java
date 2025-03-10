package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.dao.ShopInformationEditor;
import com.sotogito.coffeeshop.dao.ShopProductManager;
import com.sotogito.coffeeshop.dao.ShopSalesFileMaker;
import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.Shop;

public class AdministratorController {
    private final ShopInformationEditor shopInformationManager;
    private final ShopProductManager shopProductManager;
    private final ShopSalesFileMaker shopSalesManagement;

    public AdministratorController(ShopInformationEditor shopInformationManager, ShopProductManager shopProductManager, ShopSalesFileMaker shopSalesManagement) {
        this.shopInformationManager = shopInformationManager;
        this.shopProductManager = shopProductManager;
        this.shopSalesManagement = shopSalesManagement;
    }

    public Shop getShop() {
        return shopInformationManager.getShop();
    }

    public void editShopName(String newName){
        shopInformationManager.editShopName(newName);
    }

    public void editShopAddress(String newAddress){
        shopInformationManager.editShopAddress(newAddress);
    }

    public void editShopMasterId(int newMasterId){
        shopInformationManager.editShopMasterId(newMasterId);
    }

    public void addNewCoffeeProduct(Product product){
        shopProductManager.addNewCoffeeProduct(product);
    }

}
