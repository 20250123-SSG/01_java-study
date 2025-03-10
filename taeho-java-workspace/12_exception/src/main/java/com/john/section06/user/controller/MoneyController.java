package com.john.section06.user.controller;

import com.john.section06.user.exception.NegativPriceException;
import com.john.section06.user.exception.NegativeMoneyException;
import com.john.section06.user.exception.NotEnoughMoneyException;

/*
    try ~ catch면 이 클래스에서 처리
    throw로 직접 생성한 checkedException으로 보내서 처리
 */

public class MoneyController {
    public void checkEnoughMoney(int price, int money) throws NegativPriceException, NegativeMoneyException, NotEnoughMoneyException {

        if (price < 0) {
            throw new NegativPriceException("가격은 음수일 수 없지");
        }

        if (money < 0) {
            throw new NegativeMoneyException("돈이 음수일 수 없지");
        }

        if (money < price) {
            throw new NotEnoughMoneyException("돈이 충분하지 않습니다");
        }

        System.out.println("결제 감사합니다.");
    }
}
