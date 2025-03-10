package com.kyungbae.section06.uses.run;

import com.kyungbae.section06.uses.controller.MoneyController;
import com.kyungbae.section06.uses.exception.NegativeMoneyException;
import com.kyungbae.section06.uses.exception.NegativePriceException;
import com.kyungbae.section06.uses.exception.NotEnoughMoneyException;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) throws NegativeMoneyException, NegativePriceException, NotEnoughMoneyException {
        MoneyController mc = new MoneyController();
        Scanner sc = new Scanner(System.in);
        System.out.print("상품 가격: ");
        int price = sc.nextInt();
        System.out.print("보유 돈: ");
        int money = sc.nextInt();

        try {
            mc.checkEnoughMoney(price, money);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
