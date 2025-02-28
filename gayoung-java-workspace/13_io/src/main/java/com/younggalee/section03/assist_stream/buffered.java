package com.younggalee.section03.assist_stream;

import java.io.*;

public class buffered { //DAO
    /*
        ## 보조 스크림 ##
        1. 기반 스트림만으로 부족한 성민 및 기능을 향항시켜주는 스트림
        2. 단독으로 사용 불가
        생성시 반드시 기반 스트림 인스턴스를 전달해야됨.

        ## BufferedWriter/BufferedReader ##
        1. 입력 및 출력 데이터를 저장할 수 있는 내부 버퍼를 가지고 있음
        2. 버퍼에 데이터를 모아 한꺼번에 입력 및 출력을 하므로 출력 속도를 향상시킬 수 있음

     */

//    public void fileSave(){
//        // BufferedWriter
//        BufferedWriter bw = null;
//
//
//        try {
//            bw = new BufferedWriter(new FileWriter("c_buffer.txt")); // 보조스트림이라 단독으로 생성불가
//            bw.write("안녕하세요\n");
//            bw.write("반갑습니다.");  // 기반스트림메소드
//            bw.newLine(); //buffered writer 의 추가메소드 활용가능  // 개행
//            // 버퍼에 데이터가 쌓였다가 한번에 출력됨 >> 속도향상
//
//            // 버퍼에 쌓여있는데 가득 차있지 않아 출력이 안됨.
//            // 따라서 강제로 flush메소드를 사용해서 출력시켜야됨.
//            bw.flush();  // 근데 close로 자원반납만 잘 하면 필요 없음.
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally{
//            if(bw != null){
//                try {
//                    bw.close();  // close시 자원반납하고 flush까지 진행됨
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
    public void fileSave(){
        /*
            ## try ~ with ~ resource 구문 ##
            스트림을 다 사용하면 자동으로 반납이 진행되게 하는 구문
            jdk 1.7 이상부터 사용가능

            try(try블럭안에서 사용할 스트림 객체 생성){ // try 블럭이 다 끝난 후에 자동으로 반납

            } catch (예외클래스 e) {

            }
         */

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))) {
            bw.write("안녕하세요\n");
            bw.write("반갑습니다.");
            bw.newLine();
            bw.write("이가영");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void fileRead(){
        //bufferedReader

        try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
//            System.out.println(br.read()); // fileReader 메소드
//            System.out.println(br.readLine()); // 보조스트림 bufferedReader메소드 : 한 줄씩 읽어들여 String 으로 반환
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

    public void fileCopy(){
        //복사할 파일
        File origin = new File("C:\\dev\\env\\jdk-17.0.14_7", "NOTICE");
        File copy = new File("C:\\storage", origin.getName()); // 현재 존재하는 파일 x

        try(BufferedReader in = new BufferedReader(new FileReader(origin));
            BufferedWriter out = new BufferedWriter(new FileWriter(copy))){

            String value = null;
            while((value = in.readLine()) != null){
                out.write(value + "\n");  // 한줄씩 읽고 출력
            }
            System.out.println(copy.getPath() + " 파일 복사 완료");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


}


















