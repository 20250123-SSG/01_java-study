package com.ibe6.section03.assist_stream.convert;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class ByteToCharDao {
    /*
        ## 표준스트림 ##
        1. 콘솔이나 키보드 같은 표준 입출력 장치로부터 데이터를 입출력하기 위한 스트림
        2. System클래스의 in, out, err 필드에 해당하는 스트림
        3. 종류
           1) System.in (InputStream) : 콘솔로부터 데이터 입력
           1) System.out (PrintStram) : 콘솔로부터 데이터 입력
           1) System.out (PrintStram) : 콘솔로부터 데이터 입력
        4. 즉, 자주 사용되는.. (놓침)

     */
    public void standardStream() {
        try {
            System.out.print("입력: ");
            int input = System.in.read(); // abc입력
            System.out.println(input); // a 문자의 97 출력
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 표준스트림 => BufferedReader / BufferedWriter 보조스트림으로 성능향상

    /*
        ## InputStreamReader/OutputStreamWriter ##
        1. 형변환 보조 스트림
        2. 바이트 기반 스트림을 문자 기반 스트림으로 변환시킬때 사용
        3. 주로 보조 스트림에서 문자 스트림을 요구할 때 바이트스트림을 문자스트림으로 변환해서 사용
     */

    // * 프로그램 <= 콘솔
    public void consoleInput(){

        // System.in => InputStream(바이트스트림) => Reader(문자스트림)으로 변환해야됨
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("입력: ");
            String input = br.readLine();
            System.out.println("input: " + input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consoleOutput(){
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            bw.write("java oracle jdbc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
