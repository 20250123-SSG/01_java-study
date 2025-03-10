package section04.throws_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowsTest {

    /**
     * ## throws
     * 발생되는 예외를 위림 - 떠넘기기 예외 회피
     */
    public void exceptionCase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        try {
            System.out.println("문자열 입력");
            String input = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
        String input = br.readLine();


    }
}
