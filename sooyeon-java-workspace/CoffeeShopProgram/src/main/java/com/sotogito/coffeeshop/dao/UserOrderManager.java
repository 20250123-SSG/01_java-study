package com.sotogito.coffeeshop.dao;

import com.sotogito.coffeeshop.model.Product;
import com.sotogito.coffeeshop.model.User;

public class UserOrderManager {
    //user객체를 어디에 저정하기

    public void chargeAmount(User user, int amount){
        user.chargeAmount(amount);
    }

    public void orderByOne(User user, Product product){
        user.purchase(product);
        user.addOrder(product);
    }

}
