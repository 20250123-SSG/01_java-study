package com.seungjoo.section02.file_char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {


    public void fileSave(){

        FileWriter fw = null;
        try {
            //1. 스트림 생성
            fw = new FileWriter("b.char.txt");

            //2. write, 데이터 출력(2바이트 단위로 데이터 전송)
            fw.write(54616); //'하'
            fw.write("와");
            fw.write('A');
            fw.write("\n");

            char[] arr = new char[]{'a','p','c'};
            fw.write(arr);



        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }

        }


    }
    public void fileRead() {
        FileReader fr = null;

        try {
            fr = new FileReader("b.char.txt");


            int value = 0;
            value = fr.read();
           while(value != -1){
                System.out.println((char)value);
                break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
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
