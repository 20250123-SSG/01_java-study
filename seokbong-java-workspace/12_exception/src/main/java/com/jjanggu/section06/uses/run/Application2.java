package com.jjanggu.section06.uses.run;

import com.jjanggu.section06.uses.controller.MoneyController;
import com.jjanggu.section06.uses.exception.NegativeMoneyException;
import com.jjanggu.section06.uses.exception.NegativePriceException;
import com.jjanggu.section06.uses.exception.NotEnoughMoneyException;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args){

        MoneyController mc = new MoneyController();

        Scanner sc = new Scanner(System.in);
        System.out.println("상품 가격 : ");
        int price = sc.nextInt();
        System.out.println("보유 돈 ");
        int money = sc.nextInt();

        try {
            mc.checkEnoughMoney(price, money);
        }catch (NegativePriceException e){
            System.out.println(e.getMessage());
        }catch (NegativeMoneyException e){
            System.out.println(e.getMessage());
        }catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }finally { // 예외발생 여부와 상관 없이 반드시 실행할 내용
            System.out.println("finally 블럭 동작");
        }

        // 각 예외상황별로 따로 처리하고자 할 경우 => 다중 catch 블록
    }
}
