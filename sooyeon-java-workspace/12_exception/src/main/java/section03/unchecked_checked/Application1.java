package section03.unchecked_checked;

import java.util.Scanner;

public class Application1 {
    /**
     * Unchecked Exception
     * 예외처리구문이 없어도 프로그램이 동작되는 예외 클래스들
     *  컴파일 에러가 없어 프로그램 실행 문제 X
     *  사용자가 프로그램을 잘못 사용했더나 개발자가 특정 케이스를 처리하지 않아 발생
     *
     *  예외처리를 강제화하지 않아 예외 핸들링은 필수가 아님
     *  조건문으로 방지 가능
     *
     *  - RuntimeException 클래스 & 하위클래스
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        if(num != 0){
            System.out.println(10/num);
        }
    }
}
