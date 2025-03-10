package section01.exception;

import java.util.Scanner;

public class Application1 {
    /**
     * ## 오류 Error
     * 1. 시스템 상에서 프로그램에 심각한 문제가 발생되어 종료됨
     * 2. 오류는 개발자가 예측하여 처리할 수 없음
     * <p>
     * ## 예외
     * 1. 오류와 동일하게 프로그램이 비정상적으로 종료
     * 2. 예측 가능, 처리 가능
     * <p>
     * 자바에서는 예외 클래스들이 계층 구조로 구성되어 있음
     * throw new 예외클래스();
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /// 예외상황1. 0으로 나눔 (ArithmeticException: / by zero)
        System.out.println(10 / sc.nextInt());
    }
}
