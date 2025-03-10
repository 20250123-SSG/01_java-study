package com.kyungbae.section03.unchecked_checked;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Unchecked Exception
        System.out.print("0이 아닌 숫자만 입력");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println(num);

        if (num != 0) { // 조건문으로 해결
            System.out.println("나눗셈 결과: " + 10 / num);
        }

    }
}
