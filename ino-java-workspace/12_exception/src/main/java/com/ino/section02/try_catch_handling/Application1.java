package com.ino.section02.try_catch_handling;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("input integer");
        int num = sc.nextInt();
        try {
            System.out.println("div result : " + 10 / num);
        } catch (ArithmeticException e) {
            System.out.println("error occurred");
        }
        System.out.println("end program");
    }
}
