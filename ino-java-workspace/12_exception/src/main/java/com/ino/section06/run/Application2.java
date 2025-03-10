package com.ino.section06.run;

import com.ino.section06.uses.controller.MoneyController;
import com.ino.section06.uses.exception.NegativeMoneyException;
import com.ino.section06.uses.exception.NegativePriceException;
import com.ino.section06.uses.exception.NotEnoughMoneyException;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        MoneyController mc = new MoneyController();

        Scanner sc = new Scanner(System.in);

        int price = sc.nextInt();

        int money = sc.nextInt();

        try {
            mc.checkEnoughMoney(price, money);
        }
        catch (NegativePriceException e) {
            e.printStackTrace();
        }

        catch (NegativeMoneyException e) {
            e.printStackTrace();
        }
        catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
}
