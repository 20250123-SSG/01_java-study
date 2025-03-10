package com.sotogito.coffeeshop.view;

import com.sotogito.coffeeshop.controller.AdministratorController;
import com.sotogito.coffeeshop.controller.ShopController;
import com.sotogito.coffeeshop.model.User;

public class AdministratorView {
    private final ShopController shopController;
    private final AdministratorController administratorController;

    public AdministratorView(ShopController shopController, AdministratorController administratorController) {
        this.shopController = shopController;
        this.administratorController = administratorController;
    }

    public void run(User user){
        System.out.println("관리자 페이지입니다.");
    }
}
