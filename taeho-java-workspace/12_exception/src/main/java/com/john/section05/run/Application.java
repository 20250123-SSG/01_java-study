package com.john.section05.run;

import com.john.section05.throws_exception.ThrowTest;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ThrowTest tt = new ThrowTest();

        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("점수 입력(0~100): ");
            int score = sc.nextInt();
            tt.checkScore(score);

            System.out.print("나이 입력(0~120): ");
            int age = sc.nextInt();
            tt.checkAge(age);

            System.out.println("등급 입력(A|B|C|D): ");
            char grade = sc.next().charAt(0);
            tt.checkGrade(grade);
        }catch (Exception e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}
