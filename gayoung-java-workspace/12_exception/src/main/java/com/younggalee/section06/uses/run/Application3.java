package com.younggalee.section06.uses.run;

import com.younggalee.section06.uses.controller.MoneyController;
import com.younggalee.section06.uses.exception.NegativeException;
import com.younggalee.section06.uses.exception.NegativeMoneyException;
import com.younggalee.section06.uses.exception.NegativePriceException;

public class Application3 {
    public static void main(String[] args) {
        int price = 2000;
        int money = -500;

        MoneyController mc = new MoneyController();

        try {
            mc.checkEnoughMoney(price, money);
        } catch (NegativeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
