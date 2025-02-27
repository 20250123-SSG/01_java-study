package com.inyong.section06.users.run;

import com.inyong.section06.users.controller.MoneyController;
import com.inyong.section06.users.exception.NegativeMoneyException;
import com.inyong.section06.users.exception.NegativePriceException;
import com.inyong.section06.users.exception.NotEnoughMoneyException;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MoneyController mc = new MoneyController();

        System.out.println("상품가격");
        int price = sc.nextInt();
        System.out.println("가진 돈");
        int money = sc.nextInt();


        try {
            mc.checkEnoughMoney(price, money);
        } catch (NegativePriceException e) {
            System.out.println(e.getMessage());
        } catch (NegativeMoneyException | NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } finally {//예외 발생 여부와 상관없이 반드시 실행할 내용

        }

    }
}
