package com.ino.section02.file_char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {
    public void fileSave() {
        FileWriter fw = null;

        try {
            fw = new FileWriter("b_char.txt");
            fw.write(54616);
            fw.write("문자열예시");
            fw.write('A');
            fw.write('\n');
            char[] cArr = new char[]{'a', 'b', 'c', 'd', 'e'};
            fw.write(cArr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFile() {
        FileReader fr = null;
        try {
            fr = new FileReader("b_char.txt");
            int i;
            while ((i = fr.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
