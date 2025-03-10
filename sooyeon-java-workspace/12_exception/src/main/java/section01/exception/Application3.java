package section01.exception;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /// 문자열 -> 숫자시 예외

        /// .NumberFormatException: For input string: "[숫자가아닌입력문자열]"
        int number = Integer.parseInt(sc.nextLine());
    }
}
