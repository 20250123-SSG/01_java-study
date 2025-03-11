package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.Role;
import com.sotogito.coffeeshop.exception.MinimumChargeException;
import com.sotogito.coffeeshop.exception.UserAmountShortException;

import java.util.*;

public class User {
    private final String id;
    private final String password;
    private final String name;
    private  int amount;
    private final Role role;

    private final Cart cart;

    public User(String id, String password, String name, int amount, Role role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.amount = amount;
        this.role = role;
        this.cart = new Cart();
    }

    public void addOrder(Product product) {
        cart.addOrder(product);
    }

    public void chargeAmount(int amount) {
        if (amount <= 0) {
            throw new MinimumChargeException("1원 이상 입력해주세요.");
        }
        this.amount += amount;
    }

    public void purchase(Product product) {
        int purchaseAmount = product.getPrice();
        if (!isOverAmountThanProductPrice(purchaseAmount) || (this.amount - purchaseAmount) <= 0) {
            throw new UserAmountShortException("잔액이 부족합니다.");
        }

        this.amount -= purchaseAmount;
    }

    public Map<Product, Integer> getOrders() {
       return cart.getOrders();
    }

    public boolean isOverAmountThanProductPrice(int price) {
        return amount >= price;
    }

    public boolean isZeroAmount() {
        return amount == 0;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public Role getRole() {
        return role;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

}
