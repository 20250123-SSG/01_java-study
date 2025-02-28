package com.pch.section03.assist_stream.buffered.dao;

import java.io.*;

public class BufferedDao {
    /*
        ## 보조 스트림 ##
        1.  기반 스트림만으로 부족한 성능 및 기능을 향상시켜주는 스트림
        2.  단독으로 사용 불가
            생성시 반드시 기반 스트림 인스턴스를 전달해야됨

        ## BufferedWriter/BufferedReader ##
        1.  입력 및 출력 데이터를 저장할 수 있는 내부 버퍼를 가지고 있음
        2.  버퍼에 데이터를 모아 한꺼번에 입력 및 출력하므로 출력 속도 향상

     */

//    public void fileSave() {
//        // BufferedWriter
//
//        BufferedWriter bw = null;
//        try {
//
//            bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
//            bw.write("안녕하세요.\n");
//            bw.write("반갑습니다.");
//            bw.newLine();
//            bw.write("어서오세요.");
//
////            bw.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (bw != null) {
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public void fileSave() {
        /*
            ## try~with~resource 구문 ##
            스트림을 다 사용하면 자동으로 반납이 진행되게 하는 구문
            JDK 1.7 이상부터 사용 가능

            try(try블럭 안에서 사용할 스트림 객체 생성) { // try 블럭이 다 끝난 후에 자동으로 반납함

            } catch(예외클래스 e) {

            }
         */

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt")) ) {
            bw.write("히하");
            bw.write("디~바");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileRead() {
        try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
