package com.inyong.section06.users.run;

import com.inyong.section06.users.controller.MoneyController;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MoneyController mc = new MoneyController();

        System.out.println("상품가격");
        int price = sc.nextInt();
        System.out.println("가진 돈");
        int money = sc.nextInt();


        try {
            mc.checkEnoughMoney(price, money);
        } catch (Exception e) {
            System.out.println("에외 발생");
            System.out.println(e.getMessage());
        }

    }
}
