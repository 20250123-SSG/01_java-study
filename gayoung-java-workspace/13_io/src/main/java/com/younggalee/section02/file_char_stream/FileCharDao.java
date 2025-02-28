package com.younggalee.section02.file_char_stream;

import javax.swing.text.TabableView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {

    /*
        # FileWriter / FileReader #
        - File : 파일과 연결되는 기반 스트림
        - Writer / Reader : 데이터를 2바이트 단위로 입출력하는 문자스트림
     */

    public void fileSave() {
        // FileWriter

        FileWriter fw = null;
        try {
            // 1. 스트림 생성
            fw = new FileWriter("b_char.txt");

            // 2. 데이터 출력 (2바이트 단위로 데이터 전송)
            fw.write(54616); // '하'
            fw.write("재밌다.");

            char[] arr = new char[]{'a', 'b', 'c'};
            fw.write(arr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void fileRead() {
        //FileReader
        FileReader fr = null;
        try {
            // 1. 스트림 생성
            fr = new FileReader("b_char.txt");

            int value =0;
            while((value = fr.read()) != -1) {
                System.out.print((char)value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("읽어올 파일이 없습니다. ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
