package section02.try_catch_handling;

import java.util.Arrays;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try {
            System.out.println(10/Integer.parseInt(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        }catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            return;
        }

        System.out.println("종료");


    }
}
