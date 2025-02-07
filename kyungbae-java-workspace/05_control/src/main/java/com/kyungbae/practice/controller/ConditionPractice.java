package com.kyungbae.practice.controller;

import java.util.Scanner;

public class ConditionPractice {

    public void practice1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 입력");
        System.out.println("2. 수정");
        System.out.println("3. 조회");
        System.out.println("4. 삭제");
        System.out.println("5. 종료");

        System.out.print("메뉴 번호를 입력하세요 : ");
        int num = sc.nextInt();

        String menu = null;
        switch(num) {
            case 1:
                menu = "입력";
                break;
            case 2:
                menu = "수정";
                break;
            case 3:
                menu = "조회";
                break;
            case 4:
                menu = "삭제";
                break;
            case 5:
                System.out.println("프로그램이 종료됩니다.");
                break;
            default:
                System.out.println("잘못 입력하였습니다.");
        }
        if (menu != null) {
            System.out.print(menu + " 메뉴입니다.");
        }

    } // p1 end

    public void practice2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 한 개 입력하세요 : ");
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("양수만 입력해주세요.");
        }else if (num % 2 == 0) {
            System.out.println("짝수다");
        }else {
            System.out.println("홀수다");
        }

    } // p2 end

    public void practice3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("국어점수 : ");
        int kScore = sc.nextInt();
        System.out.print("수학점수 : ");
        int mScore = sc.nextInt();
        System.out.print("영어점수 : ");
        int eScore = sc.nextInt();

        int sum = kScore + mScore + eScore;
        int avg = sum / 3;
        if (kScore >= 40 && mScore >= 40 && eScore >=40) {
            if (avg >= 60) {
                System.out.printf("합계 : %d\n평균: %d\n 합격입니다.", sum, avg);
            }else {
                System.out.println("불합격입니다.");
            }
        }else {
            System.out.println("불합격입니다.");
        }

    } // p3 end

    public void practice4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1~12 사이의 정수 입력:");
        int month = sc.nextInt();

        String season = null;
        switch (month) {
            case 1, 2, 12:
                season = "겨울";
                break;
            case 3, 4, 5:
                season = "봄";
                break;
            case 6, 7, 8:
                season = "여름";
                break;
            case 9, 10, 11:
                season = "가을";
                break;
        }
        if (season != null ) {
            System.out.printf("%d월은 %s입니다.", month, season);
        }else {
            System.out.println("잘못 입력된 달");
        }

    } // p4 end

    public void practice5() {
        Scanner sc = new Scanner(System.in);
        String id = "kyungbae"; // 임이의 아이디
        String pw = "1q2w";     // 임이의 비밀번호

        System.out.print("아이디 : ");
        String putId = sc.nextLine();

        System.out.print("비밀번호 : ");
        String putPw = sc.nextLine();

        if (putId.equals(id)) {     // id 대조
            if (putPw.equals(pw)) { // pw 대조
                System.out.println("로그인 성공");
            }else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }else {
            System.out.println("아이디가 틀렸습니다.");
        }


    } // p5 end

    public void practice6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("등급 : 관리자, 회원, 비회원");
        System.out.print("권한을 확인하고자 하는 회원 등급 : ");
        String clas = sc.nextLine();

        switch (clas) {
            case "관리자":
                System.out.println("회원 관리, 게시글 관리");
            case "회원":
                System.out.println("게시글 작성, 댓글 작성");
            case "비회원":
                System.out.println("게시글 조회");
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }

    } // p6 end

    public void practice7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("키(m)를 입력해 주세요 : ");
        double height = sc.nextDouble();
        System.out.print("몸무게(kg)를 입력해 주세요 : ");
        double weight = sc. nextDouble();

        double bmi = weight / height * height;

        if (bmi <= 18.5 ) {
            System.out.println("저체중");
        } else if (bmi < 23) {
            System.out.println("정상");
        } else if (bmi < 25) {
            System.out.println("과체중");
        } else if (bmi < 30) {
            System.out.println("비만");
        } else {
            System.out.println("고도 비만");
        }
    } // practice7 end

} // class end
