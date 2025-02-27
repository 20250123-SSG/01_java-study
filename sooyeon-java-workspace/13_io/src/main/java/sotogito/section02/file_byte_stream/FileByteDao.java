package sotogito.section02.file_byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileByteDao {
    /**
     * ##FileOutputStream / fileInputStream
     * - Output : 데이터를 1byte단위로 출력하는 바이트 스트림
     * - Input : 데이터를 1byte단위로 입력받는 바이트 스트림
     * -
     */

    public void fileSave() {
        /**
         * 1. 스트림 생성 - 통로만들기
         * 2. 스트림으로 데이터 출력
         * 3. 사용이 끝난 스트림 반납
         */

        FileOutputStream fos = null;
        /**
         * false(기본) : 파일을 매번 새로 생성 -> 데이터 덮어 씌움
         * true : 기본 파일 데이터에 이어서 작성 -> 존재하는 파일이 아닐 경우FileNotFoundException 예외 발생
         */
        try {
            // 1. FileOutputStream 객체가 생성되면서 파일과의 연결 통로가 만들어짐
            fos = new FileOutputStream("a_byte.txt",true); //파일이 없으면 생성함

            // 2. write메서드로 데이터 출력 1바이트 범위의 데이터 -128~127 / 전송되는 데이터의 아스키문자가 저장
            fos.write(97); //a
            fos.write('b');
            //fos.write('가'); 한ㄱ르은 1바이트보다 더 큰 데이터라 꺠져서 보임

            byte[] arr = new byte[]{99, 100, 101};
            fos.write(arr); //c,d,e
            fos.write(arr, 1, 2); //d,e


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    // 3. 스트림 반납
                    fos.close(); //finally 내부에도 try-catch 선언 가능
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void fileRead() {
        /**
         *
         * FileInputStream
         *
         * 1. 스트림 생성
         * 2. 스트림 통해서 입력 받기
         * 3. 사용이 끝난 스트림 반환
         */

        FileInputStream fin = null;
        try {
            fin = new FileInputStream("a_byte.txt");

//            while (fin.read() != -1) { //반복문을 수행할 때 read()를 호출하며 확인하기 때문에 2번 실행됨
//                System.out.println(fin.read());
//            }

            //한번 읽으면 끝임 -> 아래 출력 다시해도 안나옴
//            while (true) {
//                int value = fin.read();
//                if (value == -1) {
//                    break;
//                }
//                System.out.println("ewfwef");
//                System.out.println(value);
//            }
//
//            int value = 0;
//            while ((value = fin.read()) != -1) { //조건에변수대입하면서할수있구낭
//                System.out.println((char) value);
//            }


            System.out.println("-====-=-=-=-==-=-===-=-=-=-=-==-=-=-=-=-=-==-=-==-");
            StringBuilder sb = new StringBuilder();
            while (fin.available() > 0) {
                sb.append((char) fin.read()).append(" ");
            }
            System.out.println(sb.toString());


            //1바이트 단위로 하나씩 읽어옴
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());// 읽어올거 없으면 -1 출력
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
