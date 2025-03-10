package com.kyungbae.section01.exception;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        // 예외상황3. 사용자에게 문자열을 입력받아 숫자로 변환하여 출력하기
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        String numStr = sc.nextLine(); // enter

        int num = Integer.parseInt(numStr); // NumberFormatException 발생 가능성
         // For input string: "" // enter 입력 시

        System.out.println("num: " + num);

        System.out.println("프로그램 종료");

    }
}
