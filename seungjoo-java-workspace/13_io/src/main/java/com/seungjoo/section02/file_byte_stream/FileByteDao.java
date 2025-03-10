package com.seungjoo.section02.file_byte_stream;

import java.io.*;

public class FileByteDao {


    // FileOutPutStream/ FileInputStream
    // OutPutStream : 자바 프로그램상의 데이터를 1바이트로 출력하는 바이트스트림
    // InputStream : 자바 프로그램상으로 데이터를 1바이트 단위로 입력받는 바이트 스트림

    // 프로그램(메모리) -> 외부매체(파일) : 출력


    public void fileSave() {
        //1. 스트림 생성(통로 만들기)
        //2. 스트림으로 데이터를 출력
        //3. 사용이 끝난 스트림 반납
        FileOutputStream fos = null;
        //1. FileOutPutStream 객체 생성 -> 해당 파일과의 연결통로가 만들어짐
        /*
        false 작성 : 생성모드(파일을 매번 새로이 작성 -> 데이터 덮어씌워짐(생략시 기본값)
        true 작성: 추가 모드(기존의 파일데이터에 이어서 작성) -> 존재하는 파일이 아닐경우 FileNotFoundException 발생

         */
        try {
            fos = new FileOutputStream("a_byte.txt"); //해당 파일이 없으면 새로 만들어서 연결/있으면 그냥 연결

        //2. write 메소드로 데이터 출력(1바이트 범위의 데이터 : -128~127)
        // 단, 전송되는 데이터의 아스키문자가 저장됨(즉, 0 ~ 127)
            fos.write(97); //'a'
            fos.write('b');
//            fos.write('가'); //한글은 1바이트보다 더 큰 데이터라 깨져서 저장됨 -> 바이트 스트림으로는 제한이 있음.

            byte[] arr = new byte[]{99,100,101};
            fos.write(arr); //'c', 'd', 'e'

            fos.write(arr,1,2); //'d', 'e'



        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }catch(IOException e) {
            e.printStackTrace();
        }finally{
            if(fos!=null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            //3. 스트림 반납(필수) -> 예외 발생여부와 상관없이 반드시 실행

        }
    }

    public void fileRead(){
        //FileInputStream

        //1.스트림 생성, 2. 스트림 통해서 입력받아옴. 3. 사용이 끝난 스트림 반납
        FileInputStream fis = null;
        try{fis = new FileInputStream("a_byte.txt");

        //2. read() 메소드 이용해서 읽어들이기
        // 1바이트로 하나씩 읽어옴
//        while(fis.read()!= -1){
////            System.out.println(fis.read());
//        }
            while(true){
                int value = fis.read();
                if(value == -1){
                    break; //값을 비교해서 기록
                }
                System.out.println(value);
            }

            //해결방법2
//            int value = 0;
//            while((value = fis.read()) != -1){
//                System.out.println((char)value);
//            }



//            //실습. 파일에 기록된 전체 데이터를 String 변수에 기록하시오.
//            StringBuilder result = new StringBuilder();
//            int value = 0;
//            while((value = fis.read())!=-1){
//                result.add((char)value);
//            }
//            System.out.println(result.toString());
    }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try{
                    fis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }

        }









}
