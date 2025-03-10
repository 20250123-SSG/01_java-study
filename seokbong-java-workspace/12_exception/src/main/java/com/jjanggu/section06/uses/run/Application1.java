package com.jjanggu.section06.uses.run;

import com.jjanggu.section06.uses.controller.MoneyController;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Application1 {
    public static void main(String[] args) {


        MoneyController mc = new MoneyController();

        Scanner sc = new Scanner(System.in);
        System.out.println("상품 가격 : ");
        int price = sc.nextInt();
        System.out.println("보유 돈 ");
        int money = sc.nextInt();

        try {
            mc.checkEnoughMoney(price, money);
        }catch (Exception e){
            System.out.println("예외 발생!");
            System.out.println(e.getMessage());
        }
    }
}
