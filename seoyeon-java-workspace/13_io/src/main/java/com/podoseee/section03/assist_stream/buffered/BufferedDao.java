package com.podoseee.section03.assist_stream.buffered;

import java.io.*;

public class BufferedDao {
    /*
        ## 보조 스트림 ##
        1. 기반 스트림만으로 부족한 성능 및 기능을 향상시켜주는 스트림
        2. 단독으로 사용 불가
           생성시 반드시 기반 스트림 인스턴스를 전달해야됨

        ## BufferedWriter/BufferedReader ##
        1. 입력 및 출력 데이터를 저장할 수 있는 내부 버퍼를 가지고 있음
        2. 버퍼에 데이터를 모아 한꺼번에 입력 및 출력하므로 출력 속도를 향상시킬 수 있음
     */

    /*
    public void fileSave(){
        // BufferedWriter
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("c_buffer.txt"));

            bw.write("안녕하세요.\n");
            bw.write ("반갑습니다.");
            bw.newLine(); // 추가적인 메소드 활용 가능
            bw.write("어서오세요.");
            // 버퍼에 데이터가 쌓였다가 한 번에 출력됨 => 속도 향상

            // 버퍼에 가득차야만 데이터가 출력됨
            // 강제로 출력시키고자 할 경우 => flush()
            //bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close(); // close()시 자원반납하고 flush()까지 진행됨
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    */


    public void fileSave(){
        /*
            ## try~with~resource 구문 ##
            스트림을 다 사용하면 자동으로 반납이 진행되게 하는 구문
            JDK 1.7 이상부터 사용 가능

            try(try블럭안에서 사용할 스트림객체 생성) { // try블럭이 다 끝난 후에 자동으로 반납

            } catch(예외클래스 e) {

            }
         */


        try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))) {
            bw.write("안녕하세요.\n");
            bw.write ("반갑습니다.");
            bw.newLine(); // 추가적인 메소드 활용 가능
            bw.write("어서오세요.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileRead(){
        // BufferedReader

        try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {

            // * readLine() : 한줄씩 읽어들여 String으로 반환
            /*
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());

            System.out.println(br.readLine()); // 파일의 끝을 만나는 순간 null 반환
            System.out.println(br.readLine());
            */

            String value = null;
            while((value = br.readLine()) != null ){
                System.out.println(value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileCopy(){
        // 파일 복사 : 기존 파일 가져와서 새로운 파일로 기록

        // 기존파일   ---데이터--->   프로그램   ---데이터--->  새로운파일
        //                입력                       출력

        // 복사할 파일
        File origin = new File("C:\\dev\\env\\jdk-17.0.14_7", "NOTICE"); // 현재 존재하는 파일
        File copy = new File("C:\\storage", origin.getName()); // 현재 존재하는 파일 x

        try(BufferedReader in = new BufferedReader(new FileReader(origin));
            BufferedWriter out = new BufferedWriter(new FileWriter(copy)) ) {

            String value = null;
            while((value = in.readLine()) != null){
                out.write(value + "\n");
            }

            System.out.println(copy.getPath() + "파일 복사 완료");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
