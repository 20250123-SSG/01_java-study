package com.younggalee.section03.assist_stream.convert;

import java.io.*;

public class ByteToCharDao {
    //byte를 char로 바꿔주는 Stream

    /*
        ## 표준스트림 ##
        1. 콘솔이나 키보드 같은 표준 입출력 장치로부터 데이터를 입출력하기 위한 스트림
        2. System 클래스의 in, out, err 필드에 해당하는 스트림
        3. 종류
        1) System.in (InputStream) : 콘솔로부터 데이터 입력
        2) System.out (PrintStream) : 콘솔로 데이터 출력
        3) System.err (PrintStream) : 콘솔로 데이터 출력 빨간색으로
        4. 즉, 자주 사용되는 자원에 대해 미리 스트림을 생성해두었으므로
           개발자가 별도로 스트림을 생성하지 않아도 됨.
     */

    public void standardStream() {

        try {
            System.out.println("입력 : ");
            int input = System.in.read();
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        ## InputStreamReader / OutputStreamWriter ##
        1. 형변환 보조 스트림
        2. 바이트 기반 스트림을 문자 기반 스트림으로 변환시킬때 사용
        3. 주로 보조 스트림에서 문자 스크림을 요구할 때 바이트스트림을 문자스트림으로 변환해서 사용
     */


    // 표준스트림 >> BufferedReader / bufferedWriter 보조 스트림으로 성능향상
    // 프로그램 <= 콘솔
    public void consoleInput() {
//        BufferedReader br = new BufferedReader(System.in); // 입력형태 Reader stream여야하는데 System.in은 inputStream(바이트스트림) 따라서 Reader(문자스트림)으로 변환해야됨.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("입력 : ");
            String input = br.readLine();
            System.out.println(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consoleOutput(){
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write("java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



















