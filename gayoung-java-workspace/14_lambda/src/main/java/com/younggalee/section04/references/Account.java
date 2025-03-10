package com.younggalee.section04.references;

public class Account {
    private  String ownerName;
    private int balance;

    public Account() {    }

    public Account(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
