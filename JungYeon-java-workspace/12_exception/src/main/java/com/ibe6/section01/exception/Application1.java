package com.ibe6.section01.exception;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /*
            ## 오류 (Error) ##
            1. 시스템 상에서 프로그램에 심각한 문제가 발생되어 종료되는걸 의미
            2. 오류는 개발자가 미리 예측해서 처리하는게 불가능함

            ## 예외 (Exception) ##
            1. 오류와 동일하게 프로그램이 비정상적으로 종료되나
               문제가 발생될 수 있는 상황을 미리 예측하고 처리할 수 있는 미약한 오류
            2. 예외 핸들링을 통해 예외 상황을 적절히 처리하여 코드의 흐름을 제어할 수 있음

            >> 자바에서는 예외클래스들이 계층구조로 구성되어 제공되고 있음
               특정 상황에서 throw new 예외클래스();     구문으로 예외를 발생시키고 있음

         */


        // 예외상황1. 10/사용자입력값 결과 출력
        Scanner sc = new Scanner(System.in);

        System.out.print("0이 아닌 정수: ");
        int num = sc.nextInt();

        System.out.println("나눗셈 결과: " + 10 / num); // ArithmeticException 발생 가능

        System.out.println("프로그램을 종료합니다.");


    }

}
