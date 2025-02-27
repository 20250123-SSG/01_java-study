package com.kyungbae.section06.uses.controller;

import com.kyungbae.section06.uses.exception.NegativeMoneyException;
import com.kyungbae.section06.uses.exception.NegativePriceException;
import com.kyungbae.section06.uses.exception.NotEnoughMoneyException;

public class MoneyController {

    public void checkEnoughMoney(int price, int money) throws NegativePriceException, NegativeMoneyException, NotEnoughMoneyException {

        if(price < 0){
            // 잘못된 가격 예외 발생
            throw new NegativePriceException("가격이 음수일 수 없습니다.");
        }

        if(money < 0){
            // 잘못된 돈 예외 발생
            throw new NegativeMoneyException("돈이 음수일 수 없습니다.");
        }

        if(money < price){
            // 돈 부족 예외 발생
            throw new NotEnoughMoneyException("가진 돈이 부족합니다.");
        }

        System.out.println(money + "원 미만의 제품입니다");

    }

}
