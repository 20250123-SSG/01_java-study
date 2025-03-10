package com.ino.section06.uses.controller;

import com.ino.section06.uses.exception.NegativeMoneyException;
import com.ino.section06.uses.exception.NegativePriceException;
import com.ino.section06.uses.exception.NotEnoughMoneyException;

public class MoneyController {

    public void checkEnoughMoney(int price, int money) throws NotEnoughMoneyException, NegativePriceException, NegativeMoneyException {

        if(price < 0) {
            throw new NegativePriceException("상품 가격은 음수일 수 없습니다.");
        }

        if(money<0) {
            throw new NegativeMoneyException("가지고 있는 돈은 음수일 수 없습니다.");
        }

        if(money < price) {
            throw new NotEnoughMoneyException("가진 돈 보다 상품 가격이 더 비쌉니다.");
        }
    }
}
