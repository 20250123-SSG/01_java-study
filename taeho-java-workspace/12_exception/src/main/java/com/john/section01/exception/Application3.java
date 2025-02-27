package com.john.section01.exception;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력: ");
        String numStr = sc.nextLine();

        // 형변환이 되지않는 문자 입력 시 NumberFormatException 발생
        int num = Integer.parseInt(numStr);

        System.out.println("num = " + num);
        System.out.println("프로그램 종료 ");
    }
}
