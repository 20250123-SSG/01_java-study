package com.younggalee.section06.uses.run;

import com.younggalee.section06.uses.controller.MoneyController;
import com.younggalee.section06.uses.exception.NegativeMoneyException;

public class Application {
    public static void main(String[] args) {
        int price = 2000;
        int money = -500;

        MoneyController mc = new MoneyController();

        try{
            mc.checkEnoughMoney(price, money);
        } catch (NegativeMoneyException e){
            System.out.println("catch 블럭 실행");
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("예외발생");
            System.out.println(e.getMessage());
        } finally {
            // **예외발생 여부와 상관없이** 반드시 실행할 내용
            System.out.println("A-YO Finally");
        }
    }
}
