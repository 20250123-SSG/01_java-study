package com.john.section03.unchecked_checked;

import java.util.Scanner;

/*
    Unchecked Exception
    - 예외 처리 구문이 없어도 프로그램이 동작되는 예외클래스들 (** RuntimeException 및 그 하위 클래스들)
    => compile에러가 없기 때문에 프로그램 실행에는 문제가 되지 않음
    => 사용자가 프로그램을 잘못사용하거나 특정 케이스를 제대로 처리하지 않아 발생되는 예외

    - 예외 처리를 강제화 시키지 않았기 때문에 예외 핸들리이 필수는 아님
    - 간단한 조건문으로 예외가 발생되지 않도록 하는 걸 권장
 */
public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("0이 아닌 숫자만 입력: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println(num);

        if(num != 0){
            System.out.println("나눗셈 결과: " + 10 / num);
        }
    }
}
