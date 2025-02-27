package com.john.section01.exception;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("0이 아닌 정수를 입력: ");
        int num = sc.nextInt();

        // 0 입력 시 ArithmeticException 에러 발생
        System.out.println("나눗셈 결과: " + 10 / num);

        System.out.println("프로그램 종료");
    }
}