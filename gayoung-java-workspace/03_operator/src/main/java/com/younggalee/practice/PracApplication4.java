package com.younggalee.practice;


public class PracApplication4 {
    public static void main(String[] args) {

        int x = 2;
        int y = 5;
        char c = 'A'; // 'A'의 문자코드는 65

        System.out.println(y >= 5 || x < 0 && x > 2); //  T
        System.out.println(y += 10 - x++);  // Y = 13  x = 3
        System.out.println(x += 2); // x = 5
        System.out.println( !('A' <= c && c <='Z') ); // F
        System.out.println('C' - c); //2 (아스키?)
        System.out.println('5' - '0'); //5
        System.out.println(c + 1); // 66
        System.out.println(++c);  // 66  >> B
        System.out.println(c++);  // 66  >>B
        System.out.println(c);  //67  >> C

    }
}