package com.jjanggu.prcatice.controller;

import java.util.Scanner;

public class LoopPractice {

    public void practice1(){

        Scanner sc = new Scanner(System.in);

        System.out.println("입력 : ");
        int num = sc.nextInt();

        if(num >= 1){
            for(int  i = 1; i <= num; i++) {
                System.out.print((i) + " ");
            }
        }else {
            System.out.println("잘못입력하셨습니다.");
        }
    }

    public void practice2() {
        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println("입력 : ");
            int num = sc.nextInt();

            if(num >= 1){
                for(int  i = 1; i <= num; i++) {
                    System.out.print(i + " ");
                }
                break;

            }else {
                System.out.println("잘못입력하셨습니다.다시 입력해주세요.");
            }
        }

    }

    public void practice3() {
        Scanner sc = new Scanner(System.in);

        System.out.println("입력 : ");
        int num = sc.nextInt();

        if(num >= 1){
            for(int i = 0; num-i >=1; i++){
                System.out.print(num-i+ " ");
            }
        }else {
            System.out.println("잘못 입력하셨습니다.");
        }

    }

    public void practice4() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("입력 : ");
            int num = sc.nextInt();

            if(num >= 1){
                for(int i = 0; num-i >=1; i++){
                    System.out.print(num-i+ " ");
                }
                break;
            }else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }

    }

    public void practice5() {

        Scanner sc = new Scanner(System.in);

        System.out.println("입력 : ");
        int num = sc.nextInt();

        int sum = 0;
        for(int i = 1; i <= num; i++){
            sum += i;
            if(i< num){
                System.out.print(i + " + " );
            }else if(i == num){
                System.out.print(i + " = ");
            }

        }
        System.out.println(sum);

    }

    public void practice6() {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 숫자 : ");
        int num1 = sc.nextInt();
        System.out.println("두 번째 숫자 : ");
        int num2 = sc.nextInt();
        if(num1 > 0 && num2 >0){
            if(num1 > num2){
                for(int i = num2;  i <= num1; i++) {
                    System.out.print(i + " ");
                }

            }else if(num2 > num1) {
                for(int i = num1; i <= num2; i++) {
                    System.out.print(i +" ");
                }
            }
        }else{
            System.out.println("1이상의 숫자만을 입력해주세요");
        }
    }

    public void practice7() {
        Scanner sc = new Scanner(System.in);



        while(true){
            System.out.println("첫 번째 숫자 : ");
            int num1 = sc.nextInt();
            System.out.println("두 번째 숫자 : ");
            int num2 = sc.nextInt();

            if(num1 > 0 && num2 >0){
                if(num1 > num2){
                    for(int i = num2;  i <= num1; i++) {
                        System.out.print(i + " ");
                    }

                }else if(num2 > num1) {
                    for(int i = num1; i <= num2; i++) {
                        System.out.print(i +" ");
                    }
                }
                break;
            }else{
                System.out.println("1이상의 숫자만을 입력해주세요");
            }
        }
    }

    public void practice8() {
        Scanner sc = new Scanner(System.in);

        System.out.println("입력 : ");
        int dan = sc.nextInt();
        System.out.printf("===== %d단 =====",dan);
        for(int su = 1; su <= 9; su++){

            System.out.println();
            System.out.printf("%d * %d = %d",dan, su, (su * dan));
        }

    }

    public void practice9() {
        Scanner sc = new Scanner(System.in);

        System.out.println("입력 : ");
        int num = sc.nextInt();

        for(int dan = num; dan <=9; dan++){
            System.out.println("=== " + dan + "단 ===");
            for(int su = 1; su <= 9; su++){
                System.out.println();
                System.out.printf("%d * %d = %d\n",dan, su, (su * dan));
            }
        }


    }

    public void practice10() {
        Scanner sc = new Scanner(System.in);



        while(true){
            System.out.println("입력 : ");
            int num = sc.nextInt();
            if(num >= 2 && num <= 9){
                for(int dan = num; dan <=9; dan++){
                    System.out.println("=== " + dan + "단 ===");
                    for(int su = 1; su <= 9; su++){
                        System.out.println();
                        System.out.printf("%d * %d = %d\n",dan, su, (su * dan));
                    }
                }
                break;
            }else{
                System.out.println("2~9 사이의 숫자를 입력해주세요.");
            }
        }
    }

    public void practice11() {
        Scanner sc = new Scanner(System.in);

        System.out.println("시작 숫자 : ");
        int a = sc.nextInt();
        System.out.println("공차 : ");
        int d = sc.nextInt();

        int ad = 0;
        for(int i = 0; i <= 9 ; i++){
            ad = a+d*i;
            System.out.print(ad + " ");
        }
    }

    public void practice12() {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("연산자(+,-,*,/,%) : ");
            String str = sc.nextLine();


            if(str.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{
                System.out.println("정수1 : ");
                int num1 = sc.nextInt();
                sc.nextLine();
                System.out.println("정수2 : ");
                int num2 = sc.nextInt();
                sc.nextLine();

                switch(str) {
                    case "+" :
                        System.out.println(num1 + str + num2 + "=" + (num1 + num2));
                    case "-" :
                        System.out.println(num1 + str + num2 + "=" + (num1 - num2));
                    case "*" :
                        System.out.println(num1 + str + num2 + "=" + (num1 * num2));
                    case "/" :
                        if(num2 != 0){
                            System.out.println(num1 + str + num2 + "=" + (num1 / num2));
                        }else{
                            System.out.println("0으로 나눌 수 없습니다.다시 입력해주세요.");
                        }
                        break;
                    case "%" :
                        System.out.println(num1 + str + num2 + "=" + (num1 % num2));
                    default:
                        System.out.println("없는 연산자입니다.다시 입력해주세요.");
                }
            }
        }
    }

    public void practice13() {
        Scanner sc = new Scanner(System.in);


        int n = 0;
        System.out.println("문자열 : ");
        String str = sc.nextLine();
        System.out.println("찾고자하는 문자 : ");
        char ch = sc.nextLine().charAt(0);

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch) {
                n++;
            }
        }
        System.out.println("포함된 갯수 : " + n);
    }

    public void practice14() {

        System.out.println("----------------");
        int k = 0;

        for(int j = 1; j <= ((10000/70)+1); j++ ){
            k=j*70;
            System.out.printf("%d회 모금액 : %d원\n",j,k);
        }
        System.out.println("\n총 모금횟수: " + ((10000/70)+1) + "회");
        System.out.println("----------------");
    }

    public void star1() {

        Scanner sc = new Scanner(System.in);

        System.out.println("정수 입력 : ");
        int num = sc.nextInt();

        if(num > 0) {
            for (int i = 1; i < num + 1; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }else{
            System.out.println("옳지 않은 값입니다.");
        }
    }

    public void star2() {

        Scanner sc = new Scanner(System.in);

        System.out.println("정수 입력 : ");
        int num = sc.nextInt();

        if(num > 0) {
            for (int i = num; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }else{
            System.out.println("옳지 않은 값입니다.");
        }
    }

    public void star3() {

        for( int i = 10; i < ; )

    }
}
