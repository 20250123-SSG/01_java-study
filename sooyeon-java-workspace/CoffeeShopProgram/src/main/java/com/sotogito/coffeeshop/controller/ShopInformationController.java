package com.sotogito.coffeeshop.controller;

import com.sotogito.coffeeshop.dto.PaymentDetailsDTO;
import com.sotogito.coffeeshop.exception.EmptyPaymentHistory;
import com.sotogito.coffeeshop.model.User;
import com.sotogito.coffeeshop.serivce.CoffeeShopSeller;
import com.sotogito.coffeeshop.serivce.ShopInformationService;
import com.sotogito.coffeeshop.model.Shop;

import java.util.List;
import java.util.Map;

public class ShopInformationController {
    private final ShopInformationService shopInformationService;

    public ShopInformationController(ShopInformationService shopInformationManager) {
        this.shopInformationService = shopInformationManager;
    }


    public Shop getShop() {
        return shopInformationService.getShop();
    }

    public Shop getOriginShop() {
        return shopInformationService.getOriginalShop();
    }

    public void editShopName(String newName) {
        shopInformationService.editShopName(newName);
    }

    public void editShopAddress(String newAddress) {
        shopInformationService.editShopAddress(newAddress);
    }

    public void editShopMasterId(int newMasterId) {
        shopInformationService.editShopMasterId(newMasterId);
    }

    public Map<String, List<PaymentDetailsDTO>> getPaymentDetails() {
        return CoffeeShopSeller.COFFEE_SHOP_SELLER.getPaymentDetails();
    }

    public  Map<String, List<PaymentDetailsDTO>> getPaymentDetailsByUser(User user) {
        return CoffeeShopSeller.COFFEE_SHOP_SELLER.getPaymentDetailsByUser(user);
    }

}
