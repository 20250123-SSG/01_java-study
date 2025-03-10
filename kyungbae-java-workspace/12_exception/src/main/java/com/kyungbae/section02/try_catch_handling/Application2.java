package com.kyungbae.section02.try_catch_handling;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        try {
            System.out.print("0이 아닌 정수: ");
            int num = Integer.parseInt(sc.nextLine());

            System.out.println("나눗셈 결과: " + 10/num);
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력하셔야 합니다.");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다");
        }

        System.out.println("프로그램 종료");


    }
}
