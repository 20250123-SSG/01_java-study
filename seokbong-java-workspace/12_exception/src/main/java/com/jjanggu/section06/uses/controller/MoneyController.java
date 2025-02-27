package com.jjanggu.section06.uses.controller;

import com.jjanggu.section06.uses.exception.NegativeMoneyException;
import com.jjanggu.section06.uses.exception.NegativePriceException;
import com.jjanggu.section06.uses.exception.NotEnoughMoneyException;

public class MoneyController {

    public void checkEnoughMoney(int price, int money) throws NegativePriceException , NegativeMoneyException, NotEnoughMoneyException{

        if (price < 0) {
            throw new NegativePriceException("상품 가격은 음수일 수 없습니다.") ;
            // 예외 발생
        }

        if(money < 0){
            throw new NegativeMoneyException("가지고 있는 돈은 음수일 수 없습니다.");
            // 예외 발생
        }

        if(money < price){
            throw new NotEnoughMoneyException("가진 돈 보다 상품 가격이 더 비쌉니다.");
            // 예외 발생
        }

        System.out.println("가진 돈이 충분합니다. 즐거운 쇼핑되세요~");
    }
}
