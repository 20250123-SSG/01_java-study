package section04.throws_handling;

import java.io.IOException;

public class Application {

    /// 마지막까지 예외를 떠넘기면 JVM이 처리해줌
    public static void main(String[] args) throws IOException {
        ThrowsTest tt = new ThrowsTest();


//        try {
//            tt.exceptionCase(); ///ThrowsTest에서 떠넘긴 Exception받음} catch (IOException e) {
//        }catch (IOException e) {
//
//        }

        tt.exceptionCase();
    }
}
