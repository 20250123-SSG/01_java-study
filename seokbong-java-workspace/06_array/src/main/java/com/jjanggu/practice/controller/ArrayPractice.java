package com.jjanggu.practice.controller;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

    public void practice1() {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void practice2() {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void practice3() {
        Scanner sc = new Scanner(System.in);

        System.out.println("양의 정수 : ");
        int num = sc.nextInt();
        int[] arr = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            arr[i] = i;
            System.out.print(arr[i] + " ");
        }
    }

    public void practice4() {

        String[] arr = new String[5];
        arr = new String[]{"사과", "귤", "포도", "복숭아", "참외"};


        System.out.println(arr[1]);

    }

    public void practice5() {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 : ");
        String str = sc.nextLine();
        System.out.println("문자 : ");
        char ch = sc.nextLine().charAt(0);


        char[] arr = new char[str.length()];
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
            if (arr[i] == ch) {
                cnt++;
            }
        }
        System.out.printf("%s의 개수 : %d", ch, cnt);
    }

    public void practice6() {
        Scanner sc = new Scanner(System.in);

        String[] arr = new String[]{"월", "화", "수", "목", "금", "토", "일"};

        System.out.println("0~6 사이의 숫자 입력 : ");
        int day = sc.nextInt();

        if (day >= 0 && day <= 6) {
            System.out.println(arr[day] + "요일");
        } else {
            System.out.println("잘못 입력하셨습니다.");
        }

    }

    public void practice7() {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수 : ");
        int num = sc.nextInt();

        int[] arr = new int[num]; // 입력받으 정수값 만큼의 배열생성

        System.out.println("배열 0번째 인덱스에 넣을 값 : ");
        int i0 = sc.nextInt();
        System.out.println("배열 1번째 인덱스에 넣을 값 : ");
        int i1 = sc.nextInt();
        System.out.println("배열 2번째 인덱스에 넣을 값 : ");
        int i2 = sc.nextInt();
        System.out.println("배열 3번째 인덱스에 넣을 값 : ");
        int i3 = sc.nextInt();
        System.out.println("배열 4번째 인덱스에 넣을 값 : ");
        int i4 = sc.nextInt();

        arr = new int[]{i0, i1, i2, i3, i4};

        int sum = 0;
        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }
        System.out.println("\n총합 : " + sum);
    }


    public void practice8() {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("3이상의 홀수를 입력하세요 : ");
            int num = sc.nextInt();

            int[] arr = new int[num];

            if (num >= 3 && num % 2 == 1) {
                for (int i = 0; i < num; i++) {
                    if (i <= num / 2) {
                        arr[i] = i + 1;
                    } else {
                        arr[i] = num - i;
                    }
                    if (i < num - 1) {
                        System.out.print(arr[i] + ",");
                    } else {
                        System.out.println(arr[i]);
                    }

                }
                break;
            } else {
                System.out.println("다시 입력하세요.");
            }
        }

    }

    public void practice9() {
        Scanner sc = new Scanner(System.in);

        String[] menu = new String[]{"양념", "간장", "후라이드", "핫"};

        System.out.println("치킨 이름을 입력하세요. : ");
        String name = sc.nextLine();
        boolean b = false;

        for (int i = 0; i < menu.length; i++) {

            if (menu[i].equals(name)) {
                b = true;
                break;
            }
        }

        if (b) {
            System.out.printf("%s치킨 배달 가능", name);
        } else {
            System.out.printf("%s치킨은 없는 메뉴입니다.", name);
        }

    }

    public void practice10() {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10 + 1);
            System.out.print(arr[i] + " ");
        }
    }

    public void practice11() {
        Scanner sc = new Scanner(System.in);

        System.out.println("주민등록번호(-포함) : ");
        String pn = sc.nextLine();

        char[] ch = new char[pn.length()];

        for (int i = 0; i < ch.length; i++) {
            if (i <= 7) {
                ch[i] = pn.charAt(i);
            } else {
                ch[i] = '*';
            }
            System.out.print(ch[i]);
        }
    }

    public void practice12() {

        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 10 +1);
            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    i--;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public void practice13() {
        Scanner sc = new Scanner(System.in);
        System.out.println("배열의 크기 입력 : ");
        int arrSize = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[arrSize];
        for(int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + "번째 문자열 : ");
            arr[i] = sc.nextLine();
        }
        // 입력된 배열 크기 만큼 문자열 나열


        while (true){

            System.out.println("더 값을 입력하시겠습니까?(Y/N)");
            char ans = sc.nextLine().charAt(0);


            if(ans == 'n' || ans == 'N'){
                System.out.println(Arrays.toString(arr));
                break;
            } else if (ans == 'y' || ans == 'Y') {
                System.out.print("더 입력하고 싶은 개수 : ");
                int addSize = sc.nextInt();
                sc.nextLine();



                // 새로운 빈 배열 newArr을 생성해서 코드를 다 돌린 후 arr =newArr 선언
                String[] newArr = new String[arr.length + addSize];

                for(int i = 0; i < newArr.length; i++){

                    if(i< arr.length){
                        newArr[i] = arr[i];
                    }else{
                        System.out.print((i +1) + "번째 문자열: ");
                        newArr[i] = sc.nextLine();
                    }

                }
                arr = newArr;
            }
        }
    }

    public void practice14() {
        Scanner sc = new Scanner(System.in);

        System.out.println("월 : ");
        int month = sc.nextInt();
        sc.nextLine();

        String[] seasons = {"겨울", "봄", "여름", "가을"}; //겨울 12,1,2/ 봄 3,4,5/여름 6,7,8 /가을 9,10,11

        System.out.println(seasons[(month%12)/3]);
    }

    public void practice15() {
        int[] a = {10, 20, 30, 0, 0, 0};
        int[] b = {40, 50, 60};

        // for문
        /*
        for(int i = 0; i < a.length; i++){
            if(i<b.length){
                a[i] = a[i];
            }else{
                a[i] = b[i-3];
            }
        }
         */

        // arraycopy문
        System.arraycopy(b, 0 , a, 3, 3);
        System.out.println(Arrays.toString(a));
    }

}
