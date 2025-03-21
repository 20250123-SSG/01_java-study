package com.sotogito.coffeeshop.model;

import com.sotogito.coffeeshop.common.Role;
import com.sotogito.coffeeshop.dao.PaymentFileWriter;
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

    public void addCart(Product product) {
        cart.addCart(product);
    }

    public void chargeAmount(int amount) {
        if (amount <= 0) {
            throw new MinimumChargeException("1원 이상 입력해주세요.");
        }
        this.amount += amount;
    }

    public boolean isEmptyCart(){
        return cart.isEmpty();
    }

    public void purchase() {
        int balance = cart.calculateBalance(amount);
        if(balance < 0) {
            throw new UserAmountShortException("잔액이 부족하여 최종구매할 수 없습니다..");
        }
        amount = balance;
    }

    public void updatePaymentFile(PaymentFileWriter writer){
        writer.paymentFileSave(name,cart.getOrders());
    }


    public Map<Product, Integer> getOrders() {
       return cart.getOrders();
    }

    public boolean isOverAmountThanProductPrice(int price) {
        return getBalance() >= price;
    }

    public boolean isZeroAmount() {
        return getBalance() == 0;
    }

    public boolean isNegativeAmountAfterPurchase(int productPrice) {
        return getBalance() - productPrice < 0;
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

    public int getBalance() {
        return cart.calculateBalance(amount);
    }

    public Role getRole() {
        return role;
    }

    public void clearCart() {
        cart.clear();
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
