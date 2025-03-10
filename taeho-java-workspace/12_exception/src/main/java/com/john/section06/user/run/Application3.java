package com.john.section06.user.run;

import com.john.section06.user.controller.MoneyController;
import com.john.section06.user.exception.NegativPriceException;
import com.john.section06.user.exception.NegativeException;
import com.john.section06.user.exception.NegativeMoneyException;
import com.john.section06.user.exception.NotEnoughMoneyException;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        MoneyController mc = new MoneyController();

        Scanner sc = new Scanner(System.in);
        System.out.print("상품 가격: ");
        int price = sc.nextInt();
        System.out.print("소지금액: ");
        int money = sc.nextInt();

        try {
            mc.checkEnoughMoney(price, money);
        } catch (NegativeException e) { // catch (NegativPriceException | NegativeMoneyException)
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e){
            System.out.println(e.getMessage());
        }
    }
}
