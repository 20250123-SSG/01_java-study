package com.minkook.section06.uses.run;

import com.minkook.section06.uses.controller.MoneyController;

import java.util.Scanner;

public class Application1 {
    public static void main(String [] args){
        Scanner sc  = new Scanner(System.in);
        MoneyController mc = new MoneyController();

        System.out.print("상품 가격: ");
        int price = sc.nextInt();

        System.out.print("보유 돈: ");
        int money = sc.nextInt();

        try {
            mc.checkEnoughMoney(price,money);
        }catch (Exception e){
            System.out.println("예외발생! ");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }

    }
}
