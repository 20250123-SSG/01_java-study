package com.inyong.section02.try_catch_handling;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /*
        예외 처리
        1. try - catch (예외처리)
        2. throws       (예외회피)
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("0이 아닌 정수");
        int num = sc.nextInt();


        try {
            System.out.println("나눗셈 결과 " + 10 / num); //ArithmeticException
        } catch(ArithmeticException e){
            System.out.println("0으로 나눌수 없다");
        }
    }


}
