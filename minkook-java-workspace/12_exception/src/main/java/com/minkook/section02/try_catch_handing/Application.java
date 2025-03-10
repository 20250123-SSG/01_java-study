package com.minkook.section02.try_catch_handing;

import java.util.Scanner;

public class Application {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("0이 아닌 정수: ");
        int num = sc.nextInt();

        try {
            System.out.println("나눗셈결과: " + 10/num); //ArithmeticException 발생가능
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌수 없습니다.");
        }


        System.out.println("프로그램을 종료합니다.");
    }
}
