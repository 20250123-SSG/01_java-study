package com.inyong.section05.throw_exception;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ThrowTest tt = new ThrowTest();

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("점수 입력");
            int score = sc.nextInt();
            tt.checkScore(score);

            System.out.println("나이 입력");
            int age = sc.nextInt();
            tt.checkAge(age);

            System.out.println("등급 입력");
            char grade = sc.next().charAt(0);
            tt.checkGrade(grade);
        } catch (Exception e) {
            System.out.println("예외발생");
            e.printStackTrace();
        }
    }
}
