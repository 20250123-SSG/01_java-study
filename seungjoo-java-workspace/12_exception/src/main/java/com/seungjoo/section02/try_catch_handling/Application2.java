package com.seungjoo.section02.try_catch_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("0이 아닌 정수만: ");
            int num = Integer.parseInt(sc.nextLine());

            System.out.println("나눗셈결과: " + 10 / num); //NumberFormatException 발생 가능
        }catch(ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }catch(InputMismatchException e) {
            System.out.println("정수로 변환할 수 없는 값을 입력하셨습니다.");
        }
            System.out.println("프로그램을 종료합니다."); //ArithmeticException 발생 가능





    }
}
