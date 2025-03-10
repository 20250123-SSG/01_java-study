package com.jjanggu.prcatice.controller;
import java.util.Scanner;

public class ConditionPractice {

    public void practice1() {

        Scanner sc = new Scanner(System.in);
        System.out.println("1. 입력");
        System.out.println("2. 수정");
        System.out.println("3. 조회");
        System.out.println("4. 삭제");
        System.out.println("5. 종료");
        System.out.println("메뉴 번호를 입력하세요 : ");
        int num = sc.nextInt();

        switch(num){
            case 1 :
                System.out.println("입력 메뉴입니다.");
                break;
            case 2 :
                System.out.println("수정 메뉴입니다.");
                break;
            case 3 :
                System.out.println("조회 메뉴입니다.");
                break;
            case 4 :
                System.out.println("삭제 메뉴입니다.");
                break;
            case 5 :
                System.out.println("프로그램이 종료됩니다.");
                break;
        }

    }

    public void practice2() {

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 한 개 입력하세요 : ");
        int num = sc.nextInt();

        if(num > 0){
            if(num % 2 == 0){
                System.out.println("짝수다");
            }else{
                System.out.println("홀수다");
            }
        }else{
            System.out.println("양수만 입력해주세요.");
        }

    }

    public void practice3() {

        Scanner sc = new Scanner(System.in);
        System.out.println("국어점수 : ");
        int kscore = sc.nextInt();
        System.out.println("수학점수 : ");
        int mscore = sc.nextInt();
        System.out.println("영어점수 : ");
        int escore = sc.nextInt();

        int sum = kscore + mscore + escore;
        double average = sum/3;



        if(kscore >= 40 && mscore >= 40 && escore >=40) {
            if(average >=60) {
                System.out.println("국어점수 : " + kscore);
                System.out.println("수학점수 : " + mscore);
                System.out.println("영어점수 : " + escore);
                System.out.println("합계 : " + sum);
                System.out.println("평균 : " + average);
                System.out.println("축하합니다, 합격입니다!");
            }else{
                System.out.println("불합격입니다.");
            }
        }
    }

    public void practice4() {

        Scanner sc = new Scanner(System.in);
        System.out.println("1~12 사이의 정수 입력 : ");
        int month = sc.nextInt();

        switch(month) {
            case 1, 2, 12 :
                System.out.println("겨울");
                break;
            case 3, 4, 5 :
                System.out.println("봄");
                break;
            case 6, 7, 8 :
                System.out.println("여름");
                break;
            case 9, 10, 11 :
                System.out.println("가을");
                break;
            default :
                System.out.println("잘못 입력된 달");
        }

    }





    public void practice5() {

        Scanner sc = new Scanner(System.in);
        System.out.println("===로그인===");
        System.out.println("아이디   : ");
        String id = sc.nextLine();

        System.out.println("비밀번호 : ");
        int password = sc.nextInt();

        // 컴퓨터에 저장된 아이디(..?),비밀번호(int) 만들기

        switch(id){
            case "jjanggu" :
                if(password == 123456){
                    System.out.println("로그인 성공");
                }else{
                    System.out.println("비밀번호가 틀렸습니다.");
                }
                break;

            default:
                System.out.println("아이디가 틀렸습니다.");
        }


    }


    public void practice6() {

        Scanner sc = new Scanner(System.in);
        System.out.println("권한을 확인하고자 하는 회원 등급 : ");
        String str = sc.nextLine();

        switch(str) {
            case "관리자" :
                System.out.println("회원관리, 게시글관리");
            case "회원" :
                System.out.println("게시글 작성, 댓글 작성");
            case "비회원" :
                System.out.println("게시글 조회");
                break;
            default:
                System.out.println("잘못 입력했습니다.");
        }

    }


    public void practice7() {

        Scanner sc = new Scanner(System.in);
        System.out.println("키(m)를 입력해 주세요. : ");
        double height = sc.nextDouble();

        System.out.println("몸무게(kg)를 입력해 주세요. : ");
        double weight = sc.nextDouble();

        double bmi = weight/(height * height);

        System.out.println("BMI 지수 : " + bmi);

        if(bmi < 18.5) {
            System.out.println("저체중");
        }else if(bmi < 23) {
            System.out.println("정상체중");
        }else if(bmi < 25) {
            System.out.println("과체중");
        }else if(bmi < 30) {
            System.out.println("비만");
        }else {
            System.out.println("고도비만");
        }

    }

    public void practice8() {

        Scanner sc = new Scanner(System.in);

        System.out.println("피연산자 1 입력 : ");
        int num1 = sc.nextInt();
        System.out.println("피연산자 2 입력 : ");
        int num2 = sc.nextInt();
        sc.nextLine();

        System.out.println("연산자를 입력(+,-*,/,%) : ");
        char ch = sc.nextLine().charAt(0);

        if (num1 > 0 && num2 > 0) {
            if (ch == '+') {
                System.out.printf("%d %c %d = %d", num1, ch, num2, (num1 + num2));
            } else if (ch == '-') {
                System.out.printf("%d %c %d = %d ", num1, ch, num2, (num1 - num2));
            } else if (ch == '*') {
                System.out.printf("%d %c %d = %d", num1, ch, num2, (num1 * num2));
            } else if (ch == '/') {
                System.out.printf("%d %c %d = %d", num1, ch, num2, (num1 / num2));
            } else if (ch == '%') {
                System.out.printf("%d %c %d = %d", num1, ch, num2, (num1 % num2));
            }
        } else {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");

        }

    }

    public void practice9() {
        Scanner sc = new Scanner(System.in);

        System.out.println("중간 고사 점수 : ");
        int middleScore = sc.nextInt();
        System.out.println("기말 고사 점수 : ");
        int finalScore = sc.nextInt();
        System.out.println("과제 점수 : ");
        int taskScore = sc.nextInt();
        System.out.println("출석 횟수 : ");
        double attScore = sc.nextInt();

        double rateMiddle = middleScore * 0.2;
        double rateFinal = finalScore * 0.3;
        double rateTask = taskScore * 0.3;

        double sum = rateMiddle + rateFinal + rateTask + attScore;

        if(sum >= 70 && attScore >= 20*0.7){
            System.out.println("============ 결과 ============");
            System.out.println("중간 고사 점수(20) : " + rateMiddle);
            System.out.println("기말 고사 점수(30) : " + rateFinal);
            System.out.println("과제 점수(30) : " + rateTask);
            System.out.println("출석 점수(20) : " + attScore);
            System.out.println("총점 : " + sum);
            System.out.println("PASS");
        } else if (sum < 70 && attScore >= 20 *0.7) {
            System.out.println("============ 결과 ============");
            System.out.println("FAIL[점수 미달](총점" + sum + ")");
        }else if(sum >= 70 && attScore < 20 *0.7) {
            System.out.println("============ 결과 ============");
            System.out.println("FAIL[출석 횟수 부족](" + (int)attScore +  "/20)");
        }else {
            System.out.println("============ 결과 ============");
            System.out.println("FAIL[점수 미달](총점" + sum + ")");
            System.out.println("FAIL[출석 횟수 부족](" + (int)attScore +  "/20)");
        }
    }

    public void menuView(){
        Scanner sc = new Scanner(System.in);

        System.out.println("실행할 기능을 선택하세요.");
        System.out.println("1. 메뉴출려");
        System.out.println("2. 짝수/홀수");
        System.out.println("3. 합격/불합격");
        System.out.println("4. 계절");
        System.out.println("5. 로그인");
        System.out.println("6. 권한 확인");
        System.out.println("7. BMI");
        System.out.println("8. 계산기");
        System.out.println("9. 점수 결과 출력");
        System.out.println("선택 : ");
        int menu = sc.nextInt();
        sc.nextLine();

        switch (menu){
            case 1: practice1(); break;
            case 2: practice2(); break;
            case 3: practice3(); break;
            case 4: practice4(); break;
            case 5: practice5(); break;
            case 6: practice6(); break;
            case 7: practice7(); break;
            case 8: practice8(); break;
            case 9: practice9(); break;
            default:
                System.out.println("잘못입력하셨습니다.");
        }

    }
}
