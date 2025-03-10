package com.kyungbae.section01.exception;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        // 예외상황1. 사용자 입력값 나눗셈 연산
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int num =sc.nextInt();

        System.out.println("나눗셈 결과: " + 10 / num); // ArithmeticException 발생 가능성 (/ by zero)

        System.out.println("프로그램 종료");



    }
}
