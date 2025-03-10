package section01.exception;

import java.util.Arrays;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];
        System.out.println(Arrays.toString(arr));

        System.out.println(arr[sc.nextInt()]);

        /// .ArrayIndexOutOfBoundsException: Index [입력인덱스값] out of bounds for length [실제배열길이]
    }
}
