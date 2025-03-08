package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.exception.MinimumChargeException;
import com.sotogito.coffeeshop.exception.UserAmountShortException;

import java.util.*;

public class User {
    private String id;
    private String password;
    private String name;
    private int amount;
    private boolean idAdministrator;

    private final HashMap<Product, Integer> orders = new HashMap<>(); //상품 + 주문 개수

    public User() {
    }

    public User(String id, String password, String name, int amount) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.amount = amount;
    }

    public User(String id, String password, String name, boolean idAdministrator) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.idAdministrator = idAdministrator;
    }

    public void addOrder(Product product) {
        if (orders.containsKey(product)) {
            orders.put(product, orders.get(product) + 1);
            return;
        }
        orders.put(product, 1);
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
        System.out.println(amount);
    }

    public Map<Product, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
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

    public boolean isIdAdministrator() {
        return idAdministrator;
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
                ", idAdministrator=" + idAdministrator +
                '}';
    }

}
