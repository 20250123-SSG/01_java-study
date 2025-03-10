package com.kyungbae.section03.convert;

import java.io.*;

public class ByteToCharDao {

    public void standardStream(){
        try {

            System.out.print("입력 : ");
            int input = System.in.read(); // abc
            System.out.println(input); // '97' = ('a')x

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 표준스트림 => Buffered 보조스트림으로 성능 향상

    // 프로그램 <= 콘솔
    public void consoleInput(){
        // System.in => InputStream(바이트스트림) => Reader(문자스트림) 으로 변환해야됨
        // 형변환 보조 스트림
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // => 문자스트림으로 변경, 성능 향상을 위해 보조스트림을 2겹 사용
            System.out.print("입력: ");
            String input = br.readLine();
            System.out.println("input: " + input);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void consoleOutput(){

        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write("java oracle jdbc");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
