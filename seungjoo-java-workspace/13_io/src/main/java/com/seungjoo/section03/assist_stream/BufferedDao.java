package com.seungjoo.section03.assist_stream;

import java.io.*;

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
////            bw.flush();
//            //버퍼에 데이터가 쌓였다가 한번에 출력됨 -> 속도 향상
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }finally{
//            if(bw != null){
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//
//                }
//            }
//        }
 //   }


    public void fildSave(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("c.buffer.txt"))){
            bw.write("안녕하세요.");
        }catch(IOException e){
            e.printStackTrace();
        }



    }

    public void fileRead() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("c_buffer.txt"));
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public void fileCopy(){
//        //파일 복사: 기존 파일을 가져와서 새로운 파일로 기록
//
//        File origin = new File("Users/eun07213/Desktop/dev/jadk-17.0.14_7"); //현재 존재하는 파일
//        File copy = new File("Users/eun07213/Desktop", origin.getName()); //현재 존재하는 파일x
//
//        try {
//        BufferedReader in = new BufferedReader((new FileReader(origin));
//            BufferedWriter out = new BufferedWriter(new FileWriter(copy));
//
//            String value = null;
//            while((value = in.readLine()) != null) {
//                out.write(value + "\n");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//
//        }
//
//
//    }



    }

