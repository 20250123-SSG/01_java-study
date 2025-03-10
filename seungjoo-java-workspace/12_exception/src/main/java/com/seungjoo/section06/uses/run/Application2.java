package com.seungjoo.section06.uses.run;

import com.seungjoo.section06.uses.controller.MoneyController;
import com.seungjoo.section06.uses.exception.NotEnoughMoneyException;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        MoneyController mc = new MoneyController();

        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        System.out.println("보유 돈 : ");
        int money = sc.nextInt();


    }
}
