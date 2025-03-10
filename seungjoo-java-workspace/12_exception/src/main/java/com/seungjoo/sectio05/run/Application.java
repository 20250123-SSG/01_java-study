package com.seungjoo.sectio05.run;

import com.seungjoo.sectio05.throw_exception.Throw_test;
import com.seungjoo.section04.throws_handling.ThrowsTest;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Throw_test tt = new Throw_test();

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("점수(0~100) 입력: ");

            int score = sc.nextInt();
            tt.checkScore(score);

            System.out.println("나이 입력");
            int age = sc.nextInt();
            tt.checkAge(age);

            System.out.println("등급 입력:");
            char grade = sc.next().charAt(0);
            tt.checkGrade(grade);
        } catch (Exception e) {
//            System.out.println("예외 발생");
//            System.out.println(e.getClass().getName());
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
