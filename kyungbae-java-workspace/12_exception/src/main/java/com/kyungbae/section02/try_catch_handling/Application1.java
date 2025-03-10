package com.kyungbae.section02.try_catch_handling;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int num =sc.nextInt();

        try {
            System.out.println("나눗셈 결과: " + 10 / num); // ArithmeticException 발생 가능성 (/ by zero)
        } catch (ArithmeticException e) {
            System.out.println("바버얌");
        }
        System.out.println("프로그램 종료");
    }
}
