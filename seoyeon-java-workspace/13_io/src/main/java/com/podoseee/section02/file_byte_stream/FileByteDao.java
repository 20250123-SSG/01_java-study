package com.podoseee.section02.file_byte_stream;

// * DAO(Data Access Object) : 데이터가 저장되는 외부공간에 접근해서 데이터를 주고받는 역할의 클래스

import java.io.*;

public class FileByteDao {

    /*
         ## FileOutputStream / FileInputStream ##
        - File : 파일이라는 외부매체와 직접 연결되는 "기반스트림"
        - OutputStream : 자바프로그램상의 데이터를 1byte 단위로 출력하는 "바이트스트림"
        - InputStream  : 자바프로그램상으로 데이터를 1byte 단위로 입력받는 "바이트스트림"
     */

    // * 프로그램(메모리) => 외부매체(파일) : 출력
    public void fileSave(){

        // FileOutputStream

        // 1. 스트림 생성 (통로 만들기)
        // 2. 스트림으로 데이터를 출력
        // 3. 사용이 끝난 스트림 반납 (필수)

        FileOutputStream fos = null;
        try {
            // 1. FileOutputStream 객체 생성 => 해당 파일과의 연결통로가 만들어짐
            /*
                false 작성 : 생성모드 (파일을 매번 새로이 생성 => 데이터 덮어씌워짐) (생략시 기본값)
                true  작성 : 추가모드 (기존의 파일데이터에 이어서 작성) => 존재하는 파일이 아닐경우 FileNotFoundException 발생
             */
            fos = new FileOutputStream("a_byte.txt"/*, false*/); // 해당 파일이 없으면 새로 만들어서 연결 / 있으면 그냥 연결

            // 2. write 메소드로 데이터 출력 (1byte 범위의 데이터 : -128 ~ 127)
            //    단, 전송되는 데이터의 아스키문자가 저장됨 (즉, 0 ~ 127)
            fos.write(97); // 'a'
            fos.write('b');// 'b'
            //fos.write('가');// 한글은 1byte보다 더 큰 데이터라 깨져서 저장됨 => 바이트스트림으로는 제한있음

            byte[] arr = new byte[]{99, 100, 101};
            fos.write(arr); // 'c' 'd' 'e'

            fos.write(arr, 1, 2); // 'd' 'e'

        } catch (FileNotFoundException e) { // 경로에 문제가 있으면 발생
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 스트림 반납 (필수) => 예외발생여부와 상관없이 반드시 실행
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // * 프로그램 <= 외부매체(파일) : 입력
    public void fileRead(){

        // FileInputStream

        // 1. 스트림 생성
        // 2. 스트림 통해서 입력받아옴
        // 3. 사용이 끝난 스트림 반납

        FileInputStream fin = null;
        try {
            // 1. FileInputStream 객체 생성
            fin = new FileInputStream("a_byte.txt");

            // 2. read() 메소드 이용해서 읽어들이기
            //    1byte 단위로 하나씩 읽어옴
            /*
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());

            System.out.println(fin.read()); // 파일을 다 읽어들이면 read()의 결과가 -1
            System.out.println(fin.read());
            System.out.println(fin.read());
            */

            /*
            while(fin.read() !=  -1){ // 반복문 수행시마다 매번 read() 두번씩 실행됨
                System.out.println(fin.read());
            }
            */

            // 해결방법1.
            /*while(true){
                int value = fin.read();
                if(value == -1){ // 파일의 끝을 만났을 때 멈추기
                    break;
                }
                System.out.println(value);
            }*/

            // 해결방법2.
            /*int value = 0;
            while((value = fin.read()) != -1){
                System.out.println((char)value);
            }*/

            // 실습.
            // 파일에 기록된 전체 데이터를 String 변수에 기록하시오.

            StringBuilder sb = new StringBuilder();
            int value = 0;
            while((value= fin.read()) != -1){
                sb.append((char)value);
            }
            String result = sb.toString();
            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fin != null){
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
