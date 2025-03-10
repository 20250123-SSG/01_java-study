package com.ino.section05.run;

import com.ino.section05.throw_exception.ThrowTest;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ThrowTest tt = new ThrowTest();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("점수 (0~100)입력 : ");
            int score = sc.nextInt();
            tt.checkScore(score);

            System.out.print("나이(0~120) 입력: ");
            int age = sc.nextInt();
            tt.checkAge(age);

            System.out.print("Grade Input : ");
            sc.nextLine();
            char c = sc.nextLine().charAt(0);
            tt.checkGrade(c);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
