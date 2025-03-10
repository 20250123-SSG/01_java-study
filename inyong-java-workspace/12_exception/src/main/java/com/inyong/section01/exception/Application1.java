package com.inyong.section01.exception;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /*
        오류
        1. 시스템 상에서 프로그램에 심각한 문제가 발생되어 종료
        2. 오류는 개발자가 미리 예측해서 처리 불가능

        예외
        오류와 동일하게 프로그램이 비정상적ㅇ로 종료되나
        문제가 발생될 수 있는 상황을 미리 예측하고 처리할 수 있음

        >> 자바에서는 예외 클래스들이 계층구조로 구성되어 제공되고 있음
        특정상황에서 throw new 예외클래스();
         */

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println("나눗셈 결과 " + 10 / num);
        System.out.println("프로그램 종료합니다.");
    }
}
