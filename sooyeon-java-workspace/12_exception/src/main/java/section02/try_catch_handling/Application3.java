package section02.try_catch_handling;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int[] arr = new int[sc.nextInt()];
            System.out.println(Arrays.toString(arr));

            System.out.println(arr[sc.nextInt()]);
        }
        /**
         * RuntimeException > NoSuchElementException > InputMismatchException
         * RuntimeException을 catch상단에 배치 할 경우 부모 Exception도 유효하기 때문에 처리된다.
         * 작성 순서는 구체적 -> 포괄적으로 작성한다.
         */
        catch (InputMismatchException | NumberFormatException e) {
            System.out.println("숫자만 입력하세요.");
        } catch (RuntimeException e) { //NegativeArraySizeException, ArrayIndexOutOfBoundsException의 부모 Exception
            System.out.println("배열과 관련된 문제가 발생되었습니다.");
            System.out.println(e.getClass().getName());
            e.printStackTrace();
        }

        /*
        catch (NegativeArraySizeException e) {
            System.out.println("배열의 크기는 양수만 입력해주세요.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스는 배열의 크기 범위에서 입력해주세요.");
        }
         */
    }
}
