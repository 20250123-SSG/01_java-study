package com.pch.section06.uses.run;

import com.pch.section06.uses.controller.MoneyController;
import com.pch.section06.uses.exception.NegativeMoneyException;
import com.pch.section06.uses.exception.NegativePriceException;
import com.pch.section06.uses.exception.NotEnoughMoneyException;

public class Application2 {
    public static void main(String[] args) {
        MoneyController moneyController = new MoneyController();

        int price = -1;
        int money = -1;

        try{
            moneyController.checkEnoughMoney(price, money);
        } catch (NegativeMoneyException | NegativePriceException | NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
}
