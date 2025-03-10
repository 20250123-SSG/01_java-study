package com.minkook.section02.file_char_stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {
    /*
        ## FileWriter / FileReader ##
         - File : 파일과 연결되는 기반 스트림
         - Writer/Reader : 데이터를 2byte 단위로 입출력하는 문자 스트림
     */
    public void fileSave(){
        //FileWriter

        FileWriter fw = null;

        try {
            //1. 스트림
            fw = new FileWriter("b_char.txt");

            //2. 데이터 출력(2byte 단위로 데이터 전송
            fw.write(54616); //'하'
            fw.write("와! IO 재밌다... ㅎ");
            fw.write('A');
            fw.write("\n");

            char[]arr =new char[]{'a','p','p','p','l','e'};

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        
    }

    public void fileRead(){
        //FileREader

        FileReader frd = null;

        try {
            frd = new FileReader("b_char.txt");
            StringBuilder sb = new StringBuilder();
            int value = 0;
            while ((value = frd.read()) != -1){
                //System.out.println((char)value);
                sb.append((char)value);

            }
            System.out.println(sb);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                frd.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
