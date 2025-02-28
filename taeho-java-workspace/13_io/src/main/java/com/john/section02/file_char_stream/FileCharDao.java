package com.john.section02.file_char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
    FileWriter / FileReader
    - File : 파일과 연결되는 기반 스트림
    - Writer/Reader : 데이터를 2byte단위로 입출력하는 문자 스트림
 */
public class FileCharDao {
    public void fileSave() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("b_byte.txt");
            fw.write(54165);
            fw.write("와 !");
            fw.write('A');
            fw.write("\n");

            char[] arr = new char[]{'a', 'p', 'p', 'l', 'e'};
            fw.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void fileRead() {
        FileReader fr = null;
        try{
            fr = new FileReader("b_byte.txt");
            StringBuilder sb = new StringBuilder();
            while(true){
                int value = fr.read();
                if(value == -1){
                    System.out.println("break");
                    break;
                }
                sb.append((char) value);
            }
            System.out.println(sb);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
