package com.kyungbae.section02.file_byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteDao {

    // ## FileOutputStream / FileInputStream
    // File : 외부매체 File 과 직접 연결되는 "기반스트림"
    // OutputStream : 자바프로그램상의 데이터를 1byte 단위로 출력하는 "바이트스트림"
    // InputStream : 자바프로그램상으로 데이터를 1byte 단위로 입력받는 "바이트스트림"

    // 프로그램(메모리) => 외부매체(파일) : 출력
    public void fileSave(){

        // 1. 스트림 생성 (통로 만들기)
        // 2. 스트림으로 데이터를 출력
        // 3. 사용이 끝난 스트림 반납

        FileOutputStream fos = null; // 선언을 먼저 해야 try 블럭 외에 finally 에서도 쓸 수 있다. (method에서 생성)
        try {
            // 1. FileOutputStream 객체 생성 => 해당 파일과의 연결통로가 만들어짐
            /*
                false 작성 : 생성모드 (파일을 매번 새로이 생성 => 데이터 덮어쓰기) (생략시 기본값)
                true 작성 : 추가모드 (기존의 파일데이터에 이어서 작성)
                            => 존재하는 파일이 아닐경우 FileNotFoundException 발생
             */
            fos = new FileOutputStream("a_byte.txt"/*, false*/); // 경로 입력 안할 시 project 폴더 안에 생성
            // 해당 파일이 없으면 새로 만들어서 연결 / 있으면 그냥 연결 => false 시에만.
            // FileNotFoundException 발생할 수 있음 (없는 경로 입력시 발생할 수 있음 ex) 없는 D:\...)


            // 2. write 메소드로 데이터 출력 ( 1byte 범위의 데이터 : -128 ~ 127)
            //  전송되는 데이터의 아스키문자가 저장됨 (즉, ascii의 범위 0 ~ 127)
            fos.write(97); // 'a'
            fos.write('b'); // 'b'
//            fos.write('가'); // 한글은 1byte보다 더 큰 데이터라 깨져서 저장됨 => 바이트스트림으로는 제한있음


            byte[] arr = new byte[]{99, 100, 101};
            fos.write(arr); // 'c''d''e'

            fos.write(arr, 1, 2); // 'd''e' // write(문자배열, int번 인덱스부터, int개 출력하기)


            // 3. 스트림 반납 (필수)
//            fos.close(); // => 여기서 실행 시 위쪽 코드에서 오류가 발생하면 실행을 안할 수 있다. 따라서 finally 에서 실행해준다.



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 스트림 반납 (필수) => 예외발생여부와 상관없이 반드시 실행
            // 스트림을 반납(잔류메모리)하지 않으면 메모리 누수가 발생할 수 있음
            if (fos != null) {
                try {
                    fos.close(); // 만약 new FileOutputStream 생성 시 exception이 발생하면 null 상태로 close() 가 실행될 수 있다. => 오류
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

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
            //      1byte 단위로 하나씩 읽어옴
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read());
//            System.out.println(fin.read()); // 모든 데이터를 읽은 이후 -1 출력

            /*
            while (fin.read() != -1){ // => 첫번째 read() 실행 후 검사
                System.out.println(fin.read()); // => 두번째 read() 출력
            }
             */
            // 원하는값이 안나옴

            /* 해결방법1.
            while (true){
                int value = fin.read();
                if(value == -1){
                    break;
                }
                System.out.println(value);
            }
             */

            // 해결방법 2.
            /*
            int value =0;
            while((value = fin.read()) != -1){
                System.out.print((char)value);
            }
             */

            // 실습.
            // 파일에 기록된 전체 데이터를 String 변수에 담으시오.

            StringBuilder sb = new StringBuilder();
            int value = 0;
            while ((value = fin.read()) != -1){
                sb.append((char)value);
            }
            String str = sb.toString();

            System.out.println(str);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
