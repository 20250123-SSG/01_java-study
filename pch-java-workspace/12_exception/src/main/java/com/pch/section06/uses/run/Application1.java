package com.pch.section06.uses.run;

import com.pch.section06.uses.controller.MoneyController;
import com.pch.section06.uses.exception.NegativeMoneyException;
import com.pch.section06.uses.exception.NegativePriceException;
import com.pch.section06.uses.exception.NotEnoughMoneyException;

public class Application1 {
    public static void main(String[] args) throws NegativeMoneyException, NegativePriceException, NotEnoughMoneyException {
        int price = 1000;
        int money = 900;

        MoneyController moneyController = new MoneyController();

        try {
            moneyController.checkEnoughMoney(price, money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
