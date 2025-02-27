package com.john.section02.try_catch_handling;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("0이 아닌 정수만 입력하세요: ");

        try {
            // NumberFormatException
            int num = Integer.parseInt(sc.nextLine());

            // ArithmeticException
            System.out.println("나눗셈 결과: " + 10 / num);

            System.out.println("프로그램을 종료합니다.");

        // 다중 catch 입력 가능
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (NumberFormatException e) {
            System.out.println("정수로 변환할 수 없는 값을 입력했어요");
        }

    }
}
