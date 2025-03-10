package com.seungjoo.section02.try_catch_handling;

import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("0이 아닌 정수: ");
        int num = sc.nextInt();

        try{
            System.out.println("나눗셈 결과: " + 10/num); //ArithmeticEXception 발생 가능

        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");

        }
        System.out.println("프로그램을 종료합니다.");
    }
}
