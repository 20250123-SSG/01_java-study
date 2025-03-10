package com.ino.section06.run;

import com.ino.section06.uses.controller.MoneyController;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        MoneyController mc = new MoneyController();

        Scanner sc = new Scanner(System.in);

        int price = sc.nextInt();

        int money = sc.nextInt();

        try {
            mc.checkEnoughMoney(price, money);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
