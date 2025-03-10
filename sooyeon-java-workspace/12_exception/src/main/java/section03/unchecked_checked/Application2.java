package section03.unchecked_checked;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Application2 {
    public static void main(String[] args) {
        /**
         * ## Checked Exception
         * 핸들링이 없으면 프로그램이 동작되지 않음
         */

        try {
            new URL("https://www.paulinwatches.com/");
        } catch (MalformedURLException e) {
            System.out.println("예외발생");
        }

        try {
            boolean newFile = new File("test.txt").createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
