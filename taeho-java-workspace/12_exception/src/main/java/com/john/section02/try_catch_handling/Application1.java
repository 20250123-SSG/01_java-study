package com.john.section02.try_catch_handling;

import java.util.Scanner;

/*
    exception hadling
    1. Try ~ Catch (예외 처리)
    2. throws      (예외 회피)

    try~catch
        - 발생하는 에러를 직접 처리하는 예외처리 방법
        - 예외가 발생할 가능성이 있는 구문을 try 블럭에 작성
        - 예외 발생 시 처리할 구문을 catch 블럭에 작성
 */
public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("0이 아닌 정수를 입력: ");
        int num = sc.nextInt();

        // 0 입력 시 ArithmeticException 에러 발생
        try {
            System.out.println("나눗셈 결과: " + 10 / num);
        } catch (ArithmeticException e) {
            System.out.println("헉 0으로 나눌 수 없다니");
            System.out.println(e.getMessage());
        }
        System.out.println("프로그램 종료");
    }
}
