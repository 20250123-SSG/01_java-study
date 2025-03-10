package section02.try_catch_handling;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * ## 예외 처리
         * 1. 예외 처리 : try-catch
         * 2.예외 회피 :  throws 예외를 상위 try-catch문에게 던짐
         *
         * ## try-catch
         * 예외를 잡아서 직접 처리
         * - try : 예외 발생 가능 코드
         * - catch : 예외 잡음
         *
         */

        try {
            System.out.println(10 / sc.nextInt());
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            // throw new ArithmeticException(e.getMessage());
        }
    }
}
