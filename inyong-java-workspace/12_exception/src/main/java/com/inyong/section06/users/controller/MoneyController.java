package com.inyong.section06.users.controller;

import com.inyong.section06.users.exception.NegativeMoneyException;
import com.inyong.section06.users.exception.NegativePriceException;
import com.inyong.section06.users.exception.NotEnoughMoneyException;

public class MoneyController {
    public void checkEnoughMoney(int price, int money) throws NegativePriceException, NotEnoughMoneyException, NegativeMoneyException {
        System.out.println("가진 돈이 충분합니다. 즐거운 쇼핑되세요");

        if (price < 0) {
            throw new NegativePriceException("상품 가격은 음수일 수 없습니다.");
        }

        if (money < 0) {
            throw new NotEnoughMoneyException("가진 돈 보다 상품 가격이 더 비싸");
        }
    }
}
