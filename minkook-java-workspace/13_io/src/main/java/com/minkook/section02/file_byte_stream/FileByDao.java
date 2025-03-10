package com.minkook.section02.file_byte_stream;

import java.io.*;

// * DAO(Data Access Object) : 데이터가 저장되는 외부 공간에 접근해서 데이터를 주고 받는 역할의 클래스
public class FileByDao {
    /*
        ## FileOutputStream / FileInputStream ##
        - File : 파일이라는 외부매체와 직접 연결되는 "기반 스트림 "
        - OutputStream : 자바 프로그램상의 데이터를 1byte 단위로 출력하는 "바이트 스트림"
        - IutputStream : 자바 프로그램상으로 데이터를 1byte 단위로 출력하는 "바이트 스트림"
     */
    FileOutputStream fos = null;
    public void fileSave() {
        try {
            //1. FileOutputStream 객체 생성 => 해당 파일과의 연결통로가 만들어짐
            /*
                false 작성 : 생성모드(파일을 매번 새로이 생성 => 데이터 덮어씌어짐)
                true 작성 : 이어서쓰기
             */
            fos = new FileOutputStream(new File("a_byte.txt"));

            
            //2.write 메소드로 데이터 출력(1byte 범위의 데이터 : -128 ~ 127)
            // 단, 전송되는 데이터의 아스키문자가 저장됨
            fos.write(97);
            fos.write('b');
            //fos.write('가'); //한글은 1byte보다 더 큰 데이터라 깨져서 저장됨 => 바이트 스트림 제한있음
            byte[] arr = new byte[]{99,100,101};
            fos.write(arr); // 'c', 'd','e'
            fos.write(arr,1,2);


        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //3. 스트림 반납(필수) => 예외 발생 여부와 상관없이 반드시 실행
            if(fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    // * 프로그램 <= 외부매채(파일) : 입력
    public void fileRead(){
        //FileInputStream
        //1. 스트림 생성
        //2. 스트림 통해서 입력받아옴
        //3. 사용이 끝난 스트림 반납

        FileInputStream fin = null;
        try {
            fin = new FileInputStream("a_byte.txt");
            //2 read()메소드 이용해서 읽어드리기
            //1byte 단위로 하나씩 읽어드림
            /*System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());

            System.out.println(fin.read());
            System.out.println(fin.read());
            System.out.println(fin.read());*/
            
            /*while (fin.read() != -1){ //반복문 수행시마다 매번 read() 두번씩 실행됨
                System.out.println(fin.read());
            }*/

            /*while (true){
                int value = fin.read();
                if(value == -1){
                    break;
                }
                System.out.println(value);
                //해결방법2




            }*/

           /*while ((value == fin.read()) != -1){
                System.out.println((char)value);

            }*/

            //실습
            //파일에 기록된 전체 데이터를 String 변수에 기록하시오.

            int value = 0;
            //String result = "";
            StringBuilder sb = new StringBuilder();
            while ((value = fin.read())!= -1){
                sb.append((char)value);
            }
            String result = sb.toString();
            System.out.println(result);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //3. 스트림 반납(필수) => 예외 발생 여부와 상관없이 반드시 실행
            if(fin != null){
                try {
                    fin.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
