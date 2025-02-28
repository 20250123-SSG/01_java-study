package com.younggalee.section06.uses.controller;

import com.younggalee.section06.uses.exception.NegativeMoneyException;
import com.younggalee.section06.uses.exception.NegativePriceException;
import com.younggalee.section06.uses.exception.NotEnoughMoneyException;

public class MoneyController {

    public void checkEnoughMoney(int price, int money) throws NegativePriceException, NegativeMoneyException, NotEnoughMoneyException{

        if (price < 0){
            throw new NegativePriceException("가격이 음수입니다.");
        }

        if (money < 0){
            throw new NegativeMoneyException("돈이 음수입니다."); // 잘못된 돈
        }

        if (price > money) {
            System.out.println("니 못산다.");
            throw new NotEnoughMoneyException("돈이 없습니다.");

        }
        System.out.println("가진돈이 충분하다.");
    }

}
