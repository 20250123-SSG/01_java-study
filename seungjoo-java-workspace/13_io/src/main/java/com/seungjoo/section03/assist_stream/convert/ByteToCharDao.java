package com.seungjoo.section03.assist_stream.convert;

import java.io.*;

public class ByteToCharDao {

    public void standardStream(){

        System.out.println("입력: ");
        try {
            int input = System.in.read();
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    public void consoleInput(){

        //System.in -> InputStream(바이트스트림) -> Reader(문자 스트림)으로 변환해야됨
        //주로 보조 스트림에서 문자 스트림을 요구할 때 바이트 스트림을 문자스트림으로 변환해서 사용
        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("입력");
            String input = br.readLine();
            System.out.println(input);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void consoleOutput(){
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            bw.write("자바");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
