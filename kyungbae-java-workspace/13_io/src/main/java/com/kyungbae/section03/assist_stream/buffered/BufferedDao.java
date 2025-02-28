package com.kyungbae.section03.assist_stream.buffered;

import java.io.*;

public class BufferedDao {

    /*
    public void fileSave(){
        // BufferedWriter

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("c_test.txt"));

            bw.write("가나다라마바사\n");
            bw.write("안녕하세요\n");
            bw.write("반갑습니다.");
            bw.newLine(); // 새로운 줄 추가(개행) : 추가적인 메소드 활용 가능
            bw.write("어서오세요.");
            // 버퍼에 데이터가 쌓였다가(버퍼에 가득 차면) 한꺼번에 출력됨 => 속도 향상

            // 버퍼에 가득차야만 데이터가 출력됨
            // 강제로 출력시키고자 할 경우 => flush()
//            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close(); // close()시 자원반납하고 flush() 까지 진행됨
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     */

    public void fileSave(){

        // try~with~resource 구문
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))) {
            bw.write("가나다라마바사\n");
            bw.write("안녕하세요\n");
            bw.write("반갑습니다.");
            bw.newLine();
            bw.write("어서오세요2.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileRead(){

        //BufferedReader
        try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {

            // br.readLine() : // 개행 기준 한줄 읽기 (String 반환)
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine()); // null

            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }

            StringBuilder sb = new StringBuilder();
            String str2 = null;
            while ((str2 = br.readLine()) != null){
                sb.append(str2).append("\n");
            }
            System.out.println(sb);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileCopy(){
        // 파일 복사 : 기존 파일 가져와서 새로운 파일로 기록

        // 복사할 파일
        File origin = new File("C:\\dev\\env\\jdk-17.0.14_7","NOTICE"); // 현재 존재하는 파일
        File copy = new File("C:\\storage", origin.getName()); // 현재 존재하는 파일 X

        try(BufferedReader in = new BufferedReader(new FileReader(origin));
            BufferedWriter out = new BufferedWriter(new FileWriter(copy))) {

            String str = null;
            while ((str = in.readLine()) != null){
                out.write(str + "\n"); // 입력파일에 읽어진 readLine 을 그대로 write로 출력 (개행문자는 미포함이라 추가)
            }

            System.out.println(copy.getPath() + "파일 복사 완료");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
