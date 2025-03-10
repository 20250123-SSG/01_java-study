package com.minkook.section03.assist_stream.buffered;

import java.io.*;

public class ByteToCharDao {
    
    /*
        ## 표준 스트림 ##
        1. 콘솔이나 키보드 같은 표준 입출력 장치로부터 데이터를 입출력하기 위한  스트림
        2. System 클래스의 in,out,err 필드에 해당하는 스트림
        3. 종류
            1) System.in (InputStream) : 콘솔로부터 데이터 입력
            2) System.out (PrintStream) : 콘솔로 데이터 출력
            3) System.err(PringStream) : 콘솔로 데이터 출력
        4. 즉 자주사용되는 자원에 대해 미리 스트림을 생성해두었으므로
            개발자가 별도로 스트림을 생성하지 않아도됨
     */
    public void standardStream(){

        try {
            System.out.print("입력"); //abc
            int input = System.in.read();   //a 문자의 97 출력
            

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    /*
        ## InputStreamReader/OutputStreamWriter ##
     */
    
    //표준 스트림 => BufferedReader/BufferedWriter 보조스트림 성능향상
    // * 프로그램 <= 콘솔
    public void consoleInput(){
        //;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("입력"); //abc
            int input = System.in.read();   //a 문자의 97 출력
            System.out.println("input: " + input);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void consoleOuput(){
        //;

        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write("java oracle jdbc");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
