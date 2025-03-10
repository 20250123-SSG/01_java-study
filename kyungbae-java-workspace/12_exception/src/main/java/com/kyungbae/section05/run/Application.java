package com.kyungbae.section05.run;

import com.kyungbae.section05.throw_exception.ThrowTest;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ThrowTest tt = new ThrowTest();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("점수(0~100) 입력 : ");
            int score = sc.nextInt();
            tt.checkScore(score);

            System.out.print("나이(0~120) 입력 : ");
            int age = sc.nextInt();
            tt.checkAge(age);

            System.out.print("등급(A~D) 입력 : ");
            char grade = sc.next().charAt(0);
            tt.checkGrade(grade);
        } catch (Exception e) {
//            System.out.println("잘못된 접근");
//            System.out.println(e.getClass().getName());
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
