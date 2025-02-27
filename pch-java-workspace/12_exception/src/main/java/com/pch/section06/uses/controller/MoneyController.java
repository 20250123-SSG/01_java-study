package com.pch.section06.uses.controller;

import com.pch.section06.uses.exception.NegativeMoneyException;
import com.pch.section06.uses.exception.NegativePriceException;
import com.pch.section06.uses.exception.NotEnoughMoneyException;

public class MoneyController {
    public void checkEnoughMoney(int price, int money) throws NegativePriceException, NegativeMoneyException, NotEnoughMoneyException {

        if(price < 0) {
            throw new NegativePriceException("상품 가격은 음수일 수 없습니다.");
        }

        if(money < 0){
            // 예외 발생
            throw new NegativeMoneyException("가지고 있는 돈은 음수일 수 없습니다.");
        }

        if(price > money){
            // 예외 발생
            throw new NotEnoughMoneyException("가진 돈이 상품 가격보다 적습니다. 거지에요?");
        }

        System.out.println("가진 돈이 충분합니다. 즐거운 쇼핑되세요~");
    }
}
