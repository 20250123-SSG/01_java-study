package com.john.section03.assist_stream.buffered;

import java.io.*;

/*
    BufferedReader/BufferedWriter
    1. 출력 및 입력 데이터를 저장할 수 있는 내부 버퍼를 가지고 있음
    2. 버퍼에 데이터를 모아 한꺼번에 입출력하므로 출력속도 향상
 */
public class BufferedDao {
//    public void fileSave(){
//        BufferedWriter bw = null;
//        try {
//            bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
//
//            bw.write("안녕하세요.\n");
//            bw.write("반갑습니다.");
//            bw.newLine();
//            bw.write("어서오세요.");
//
//            // 버퍼에 가능차야 데이터 출력, 강제로 출력시킬때 flush()실행
//            bw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            if(bw != null) {
//                try{
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public void fileSave() {
        /*
            try ~ with ~ resource
            스트림 전부 사용 시 자동으로 반납이 진행되게 하는 구문
         */
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))){
            bw.write("안녕하세요.\n");
            bw.write("반갑습니다.");
            bw.newLine(); // 메서드 사용가능
            bw.write("어서오세요.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void fileRead() {
        BufferedReader br = null;
//        try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
//
//            br.readLine();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        String value = null;
        while (true){
            try {
                if (!((value = br.readLine())!= null)) break;
            } catch (FileNotFoundException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.println(value);
        }
    }

    public void fileCopy(){
        /*
            기존파일 -- 데이터 입력 =>  프로그램 -- 데이터 출력 => 새로운 파일
         */
        File origin = new File("c_buffer.txt"); // 현재 존재하는 복사할 타겟
        File dest = new File("Wow_Copyc_buffer.txt");

        try(BufferedReader in = new BufferedReader(new FileReader(origin));
        BufferedWriter out = new BufferedWriter(new FileWriter(dest)) ){

            //content
            String line = null;
            while ((line = in.readLine()) != null) {
                out.write(line + "\n");
            }
            System.out.println(dest.getPath() + "파일 복사 완료");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
