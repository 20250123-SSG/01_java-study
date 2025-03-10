package com.minkook.section05.run;

import com.minkook.section05.throw_exception.ThrowTest;
import com.minkook.section05.user_exception.IncorrectAgeException;

import java.util.Scanner;

public class Application {
    public static void main(String [] args){
        ThrowTest tt= new ThrowTest();

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("점수(0~100) 입력: ");
            int score = sc.nextInt();
            sc.nextLine();
            tt.checkScore(score);

            System.out.print("나이(0~120) 입력: ");
            int age = sc.nextInt();
            sc.nextLine();
            tt.checkAge(age);


            System.out.print("등급(A~D) 입력: ");
            char grade = sc.nextLine().charAt(0);
            tt.checkGrade(grade);
        }catch (Exception e){
            System.out.println("예외발생!!");
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}
