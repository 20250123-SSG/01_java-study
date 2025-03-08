package com.ibe6.practice.controller;

import java.util.Scanner;

public class LoopPractice {
    public void practice1() {
        /*
        사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
        단, 입력한 수는 1보다 크거나 같아야 합니다.
        만일 1 미만의 숫자가 입력됐다면 “잘못 입력하셨습니다.“를 출력하세요.
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("1이상의 숫자를 입력하세요: ");
        int inputNum = sc.nextInt();

        if (1 <= inputNum) {
            int num = 1;
            while (num <= inputNum) {
                System.out.print(num++ + " ");
            }
        } else {
            System.out.println("잘못 입력하셨습니다.");
        }
    }

    public void practice2() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("1이상의 숫자를 입력하세요: ");
            int inputNum = sc.nextInt();

            if (1 <= inputNum) {
                int num = 1;
                while (num <= inputNum) {
                    System.out.print(num++ + " ");
                }
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    public void practice3() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("1이상의 숫자를 입력하세요: ");
            int inputNum = sc.nextInt();
            if (inputNum >= 1) {
                for (int i = 1; i <= inputNum; i++) {
                }
                System.out.println();
                for (int i = inputNum; i >= 1; i--) {
                    System.out.print(i + " ");
                }

                System.out.println();
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    public void practice4() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("1이상의 숫자를 입력하세요: ");
            int inputNum = sc.nextInt();
            if (inputNum >= 1) {
                for (int i = 1; i <= inputNum; i++) {
                }
                System.out.println();
                for (int i = inputNum; i >= 1; i--) {
                    System.out.print(i + " ");
                }

                System.out.println();
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    public void practice5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요: ");
        int num = sc.nextInt();

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
            if (i < num) {
                System.out.print(i + " + ");
            } else {
                System.out.println(num + " = " + sum);
            }
        }
    }

    public void practice7() {
        /*
        사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
        만일 1 미만의 숫자가 입력됐다면 “1이상의 숫자만을 입력해주세요“를 출력하세요.
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 숫자: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자: ");
        int num2 = sc.nextInt();

        while (true) {
            if(num1 >= 1 && num2 >= 1) {
                int min = Math.min(num1, num2); // 호출시 비교
                int max = Math.min(num1, num2);
            for (int i=min; i<=max; i++ ) {
                System.out.print(i + " ");
            }
            System.out.println();
            break;

            }else{
                System.out.print("1이상의 숫자만을 입력해주세요");
            }

    }

    }

    public void practice8() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자: ");
        int dan = sc.nextInt();
        for (int su = 1; su <= 9; su++) {
            System.out.printf("%d x %d = %d\n", dan, su, dan * su);
        }

    }

    public void practice9() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("숫자(2~9): ");
            int dan = sc.nextInt();

            if (dan >= 2 && dan <= 9) {
                System.out.println("===== " + dan + "단 =====");
                for (int su = 1; su <= 9; su++) {
                    System.out.printf("%d x %d = %d\n", dan, su, dan * su);
                }
                break;
            } else {
                System.out.println("2~9사이의 숫자만 입력해주세요.");
            }
        }
    }

    public void practice10() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("숫자(2~9): ");
            int dan = sc.nextInt();

            if (dan >= 2 && dan <= 9) {
                System.out.println("===== " + dan + "단 =====");
                for (int su = 1; su <= 9; su++) {
                    System.out.printf("%d x %d = %d\n", dan, su, dan * su);
                }
                break;
            } else {
                System.out.println("2~9사이의 숫자만 입력해주세요.");
            }
        }
    }

    public void practice11() {
        Scanner sc = new Scanner(System.in);
        System.out.print("시작 숫자: ");
        int startNum = sc.nextInt();
        System.out.print("공차: ");
        int blankNum = sc.nextInt();
        for(int i=0; i<10; i++){
            System.out.print(startNum + " ");
            startNum += blankNum;
        }
    }

    public void practice12() {
        Scanner sc = new Scanner(System.in);
    /*
    정수 두 개와 연산자(문자열)로 입력 받고 입력된 연산자에 따라 알맞은 결과를 출력하세요.
    단, 해당 프로그램은 연산자 입력에 “exit”라는 값이 들어올 때까지 무한 반복하며
    “exit”가 들어오면 “프로그램을 종료합니다.”를 출력하고 종료합니다.
    또한 연산자가 나누기이면서 두 번째 정수가 0으로 들어오면
    “0으로 나눌 수 없습니다. 다시 입력해주세요.”를 출력하며,
    없는 연산자가 들어올 시 “없는 연산자입니다. 다시 입력해주세요.”라고 출력하고
    두 경우 모두 처음으로 돌아가 사용자가 다시 연산자부터 입력하도록 하세요.
     */
    /*
        무한반복 {
            1. 연산자 이벽받기
            2. 정수 두개 입력받기
                >> 연산자가 / 거나 % 일때 두번째 정수값이 0일 경우 => "0으로 나눌수없다~~"
                   반복문 다시 시작
            3. 연산기호에 따라 해당 연산 결과 출력
                >> 연산기호를 잘못 입력했을 경우 => "없는 연산자다~~" 반복문 다시 시작
        }
     */
        while (true) {
            // 1. 연산자 입력받기
            System.out.print("연산자(+, -, *, /, %) : ");
            String op = sc.nextLine();

            // >> exit처리
            if(op.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 2. 정수 두개 입력받기
            System.out.print("정수1 : ");
            int num1 = sc.nextInt();
            System.out.print("정수2 : ");
            int num2 = sc.nextInt();

            sc.nextLine(); // 버퍼 비우기

            // >> 나눗셈 처리
            if((op.equals("/") || op.equals("%")) && num2 == 0){
                System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요. \n");
                continue;
            }

            // 3. 연산 기호에 따라 해당 결과 출력
            int result = 0; // 연산결과를 기록할 변수
            switch (op) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                default: // >> 없는 연산자 처리
                    System.out.println("없는 연산자입니다. 다시 입력해주세요.\n");
                    continue;
            }
            System.out.printf("%d %s %d = %d\n\n", num1, op, num2, result);
        }
    }

    public void practice13() {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열: ");
        String serch = sc.nextLine();
        System.out.print("찾고자 하는 문자: ");
        char op = sc.nextLine().charAt(0);

        int count = 0;
        for (int i = 0; i < serch.length(); i++) {
            if (serch.charAt(i) == op) {
                count++;
            }
        }
        System.out.println("포함된 갯수:" + count);
    }

    public void practice14() {
        int plus = 70;
        int sum = 0;
        int count = 0;

        for (int i = 1; sum <= 10000; i++) {
            sum += plus;
            System.out.println("--------------------");
            System.out.println( i + "회 모금액: " + sum );
            count++;
        }
        System.out.println("총 모금횟수: " + count + "회");
    }


}

