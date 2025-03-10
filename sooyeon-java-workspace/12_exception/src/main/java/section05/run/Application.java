package section05.run;

import section04.throws_handling.ThrowsTest;
import section05.throw_exception.ThrowTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ThrowTest tt = new ThrowTest();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("점수를 입력(0~100)");
            tt.checkScore(sc.nextInt());

            System.out.println("나이(0~120");
            tt.checkAge(sc.nextInt());

            System.out.println("등급(A~D)");
            tt.checkGrade(sc.nextLine().charAt(0));
        } catch (Exception e) {
            System.out.println("예외");
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
