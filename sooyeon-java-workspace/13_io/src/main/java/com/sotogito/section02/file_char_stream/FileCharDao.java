package com.sotogito.section02.file_char_stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {
    /**
     * ## FileWriter
     * - File : 파일과 연결되는 기반의 스트림
     * - Writer : 데이터를 1바이트 단위로입출력하는 문자스트림
     */

    public void fileSave() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("b_char.txt");

            fw.write(54616); // '하' (Unicode 54616)
            fw.write("댐잇다");
            fw.write('A');
            fw.write("\n");
            fw.write(new char[]{'a', 'b', 'c', 'd', 'e', 'f'});

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void fileRead() {
        FileReader fr = null;
        try {
            fr = new FileReader("b_char.txt");

            while (fr.ready()) {
                System.out.print((char) fr.read());
            }

//            int readResult = 0;
//            while ((readResult = fr.read()) != -1) {
//                System.out.println((char) readResult);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
