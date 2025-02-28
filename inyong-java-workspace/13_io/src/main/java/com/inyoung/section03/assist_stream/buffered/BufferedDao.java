package com.inyoung.section03.assist_stream.buffered;

import java.io.*;

public class BufferedDao {

    /*
    ## 보조 스트림 ##
    1. 기반 스트림만으로 부족한 성능 및 기능을 향상시켜주는 스트림
    2. 단독으로 사용 불가
        생성시 반드시 기반 스트림 인스턴스를 전달해야됨

    ## BufferedWriter / BufferedReader ##
    1. 입력 및 출력 데이터를 저장할 수 있는 내부 버퍼를 가지고 있음
    2. 버퍼에 데이터를 모아 한꺼번에 입력 및 출력하므로 출력 속도 향상
     */
/*
    public void fileSave() {
        //BufferedWriter
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("c_buffer.txt"));

            bw.write("\n");
            bw.write("hi");
            bw.newLine();
            // 버퍼에 데이터가 쌓였다가 한번에 출려고됨 -> 속도 향상
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (bw != null) {
                try{
                    bw.close(); // wkdnjs qkeskqgkrh flush까지 진행됨
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
*/
    public void fileSave() {

        /*
        ## try~with~resource 구문 ##
        스트림을 다 사용하면 자동우로 반납이 진행되게 하는 구문
        JDK 1.7 이상부터 사용 가능

        try(try블럭안에서 사용할 스트림 객체 생성){ // try 블럭이 다 끝난 후에 자동으로 반납
        } catch(예외클래스 e){
        }

         */


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))) {
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void fileRead() {
        // BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {

//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());

            String value = null;
            while ((value = br.readLine()) != null) {
                System.out.println(value);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void fileCopy() {
        // 파일 복사 : 기존 파일 가져와서 새로운 파일로 기록

        // 기존파일 -- 데이터 --> 프로그램 --데이터 --> 새로운 파일
        //          입력                출력

        // 복사할 파일
        File origin = new File("Users/in-yong/asdf", "NOTICE"); //현재 존재하는 파일
        File copy = new File("Users/in-yong/asdf", origin.getName()); // 복사할 파일

        try (BufferedReader in = new BufferedReader(new FileReader(origin));
             BufferedWriter out = new BufferedWriter(new FileWriter(copy))) {

            String value = null;

            while ((value = in.readLine()) != null) {
                out.write(value + "\n");
            }
            System.out.println(copy.getPath() + " 파일 복사 완료");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
