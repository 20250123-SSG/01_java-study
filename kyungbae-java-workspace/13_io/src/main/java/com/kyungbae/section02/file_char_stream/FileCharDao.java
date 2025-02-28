package com.kyungbae.section02.file_char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {

    public void fileSave(){

        //FileWriter

        FileWriter fw = null;
        try {
            // 1. 스트림 생성
            fw = new FileWriter("b_char.txt");

            // 2. 데이터 출력
            fw.write(54616); // '하'
            fw.write("와 재밌다..! 긴 한글도 넘어가다니");
            fw.write('t');
            fw.write("\n");
            fw.write("줄바꿈\n");

            char[] arr = new char[]{'a', 'p', 'p', 'l', 'e'};
            fw.write(arr);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void fileReader(){

        FileReader fr = null;

        try {
            fr = new FileReader("b_char.txt");

//            System.out.println(fr.read());

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while ((i = fr.read()) != -1 ){
                sb.append((char)i);
            }
            String str = sb.toString();
            System.out.println(str);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
