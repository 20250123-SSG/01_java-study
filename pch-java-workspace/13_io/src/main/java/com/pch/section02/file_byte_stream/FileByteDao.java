package com.pch.section02.file_byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  ## DAO(Data Access Object) ##
 *  데이터가 저장되는 외부 공간에 접근해서 데이터를 주고받는 역할의 클래스
 */
public class FileByteDao {

    /*
        ## FileOutputStream / FileInputStream ##

     */
    public void FileSave(){
       FileOutputStream fos = null;

       try{
           // 1. FileOutputStream 객체 생성 => 해당 파일과의 연결통로가 만들어짐
           /*
                false 작성 : 생성모드 (파일을 매번 새로이 생성 => 데이터 덮어씌워짐) 생략시 기본값
                true  작성 : 추가모드 (기존의 파일데이터에 이어서 작성) => 존재하는 파일이 아닐경우 FileNotFoundException 발생
            */

           fos = new FileOutputStream("src/main/java/com/pch/section02/stream/testOutputStream.txt", true);

           /* writer() 메소드는 IOException을 핸들링 해야 한다. */
           fos.write(97);

           /* 실행하고 testOutputStream.txt 파일을 열어보면 a가 기록되어 있다. */

           /* byte 배열을 이용해서 한 번에 기록할 수 도 있다.
            * 10 : 개행문자 (엔터)
            * */
           byte[] bar = new byte[] {98, 99, 100, 101, 102, 10};
           fos.write(bar);

       } catch (IOException e){
           e.printStackTrace();
       } finally {
           if(fos != null){
               try{
                   fos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
    }

    // * 프로그램 <= 외부매체(파일) : 입력
    public void FileRead(){

        // FileInputStream 사용

        // 1. 스트림 생성
        // 2. 스트림 통해 입력받아옴
        // 3. 사용이 끝난 스트림 반납

        FileInputStream fis = null;

        try{
            fis = new FileInputStream("src/main/java/com/pch/section02/stream/testOutputStream.txt");

            while(true){
                int n = fis.read();
                if(n == -1){
                    break;
                }
                System.out.println((char)n);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
