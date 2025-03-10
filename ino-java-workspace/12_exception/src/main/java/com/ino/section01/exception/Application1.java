package com.ino.section01.exception;

import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("input integer");
        int num = sc.nextInt();
        System.out.println("div result : " + 10 /num);
        System.out.println("end program");
    }
}
