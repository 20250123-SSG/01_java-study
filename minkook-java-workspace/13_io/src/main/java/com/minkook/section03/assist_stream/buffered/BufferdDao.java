package com.minkook.section03.assist_stream.buffered;

import java.io.*;

public class BufferdDao {
    /*
        ## 보조 스트림 ##
        1. 기반 스트림만으로 부족한 성능 및 기능을 향상시켜주는 스트림
        2. 단독으로 사용불가
            생성시 반드시 기반 스트림 인스턴스를 전달해야됨

        ## BufferedWriter/BufferedReader ##
     */
    public void fileSave(){
        //BufferedWriter
        /*BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("c_buffer.txt"));

            bw.write("안녕하세요.\n");
            bw.write("반갑습니다.");
            bw.newLine();
            bw.write("어서오세요.");
            //버퍼에 데이터가 쌓였다가 한번에 출력됨 => 속도 향상

            //버퍼에 가득차야만 데이터가 출력됨
            //강제로 출력시키고자 할 경우 => flush()
            //bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close(); //close()시 자원반납하고 flush()까지 진행됨
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }*/

        /*
            ## try-with~resource 구문 ##

         */
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))){
            bw.write("안녕하세요.\n");
            bw.write("반갑습니다.");
            bw.newLine();
            bw.write("어서오세요.");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void fileRead(){
        //BufferedReader

        try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){
            //System.out.println(br.readLine());
            String value = null;
            while ((value = br.readLine()) != null){
                System.out.println(value);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void fileCopy(){
        //파일 복사 : 기존 파일 가져와서 새로운 파일 기록

        //기존 파일 ---데이터 ---> 프로그램 ----데이터 ---> 새로운 파일
        //             입력                     출력

        // 복사할 파일
        File origin = new File("C:\\dev\\env\\jdk-17.0.14_7","NOTICE"); //현재 존재하는 파일
        File copy = new File("C:\\storage",origin.getName()); //현재 존재하는 파일

        try(BufferedReader in = new BufferedReader(new FileReader(origin));
            BufferedWriter out = new BufferedWriter(new FileWriter(copy)) ){

            String value = null;
            while ((value = in.readLine()) != null){
                out.write(value + "\n");
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
