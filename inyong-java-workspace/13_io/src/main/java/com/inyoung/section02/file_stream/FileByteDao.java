package com.inyoung.section02.file_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteDao {
    // * DAO
    /*
    ## FileOutputStream / FileInputStream
    - File : 파일이라는 외부 매체와 직접 연결되는 "기반스트림"
    - OutputStream : 자바프로그램상의 데이터를 1byte 단위로 출력하는 바이트스트림
    - InputStream : 자바프로그램상의 데이터를 1byte 단위로 입력받는 바이트스트림
     */

    //* 프로그램 메모리 => 외부매체(파일) : 출력
    public void fileSave() {


    /*
    1 스트림 생성 통로 만들기
    2 스트림으로 데이터를 출력
    3 사용이 끝난 스트림 반납
     */


        try {
            // 1 FileOutputStream 객체 생성 => 연결통로
            FileOutputStream fos = new FileOutputStream("a_byte.txt");

            // 2 write 메소드로 데이터 출력 (1byte 범위의 데이터 : -128 ~ 127)
            // 단 전송되는 데이터의 아스키 문자가 저장됨
            fos.write(97);  // 'a'
            fos.write('b'); // 'b'
            fos.write('가'); // 'a' 한글은 1byte 보다 더 큰 데이터라 깨져서 저장됨 => 바이트스트림으로는 제한 있음

            byte[] arr = new byte[]{99, 100, 101};
            fos.write(arr);

            fos.write(arr, 1, 2); // 'd' 'e'

            // 3. 스트림 반납 (필수)
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
