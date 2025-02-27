package com.john.section02.file_byte_stream;

import java.io.*;

/*
    DAO(Data Access Object): 데이터가 저장되는 외부공간에 접근해서 데이터를 주고받는 역할의 클래스
    FileOutputStream / FileInputStream
    File        : 파일이라는 외부매체와 직접 연결되는 "기반스트림"
    OutputStream: 자바 프로그램상의 데이터를 1byte단위로 출력하는 바이트 스트림
    InputStream : 자바 프로그램상으로 데이터를 1byte단위로 입력받는 바이트 스트림
 */
public class FileByteDao {
    public void fileSave() {
        FileOutputStream fos = null;
        try {
            // true : 추가모드(기존 파일데이터에 이어서 작성) => 파일이 존재하지 않으면 FileNotFound
            // false : 생성모드(파일을 매번 새로이 생성 => 매번 덮어쓰기,default 값 )
            fos = new FileOutputStream("a_byte.txt",true); // true,false가능
            // new File() 해당 파일이 없으면 자동으로 생성
            // 출력 파일에 대한 정보
            // fos: 통로이자 객체
            // 1. FileOutputStream객체 생성 => 해당 파일과의 연결통로가 만들어짐 
            // 2. write 메서드로 데이터 출력(1byte 범위 데이터: -128 ~ 127)
            // 단, 전송되는 데이터의 아스키문자가 저장됨
            fos.write(97);
            fos.write('b');

            byte[] bytes = new byte[]{99,100,101};
            fos.write(bytes);
            fos.write(bytes, 1, 2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 스트림 반납(필수)
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void fileRead() {
        // FileInputStream
        // 스트림 생성 => 스트림을 통해 입력받음 => 사용끝난 스트림 반납
        FileInputStream fis = null;
        try {
            // 스트림 생성
            fis = new FileInputStream("a_byte.txt");


            //read() 메서드를 이용해서 1byte 단위로 하나씩 읽기
//            while(fis.read()!= -1) 잘못된 조건(read()시 계속 파일이 읽힘)
//            while(fis.available() > 0)
//            while(true){
//                int value = fis.read();
//                if(value == -1){
//                    break;
//                }
//                System.out.println(fis.read());
//            }
            StringBuilder sb = new StringBuilder();
            while (fis.available() > 0) {
                sb.append((char) fis.read());
            }

            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
