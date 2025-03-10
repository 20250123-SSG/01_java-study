package com.seungjoo.section01.exception;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {


        Scanner sc =  new Scanner(System.in);
        System.out.println("정수:");
        int number = sc.nextInt();
        System.out.println(10/number);
        System.out.println("프로그램을 종료합니다.");

    }
}
