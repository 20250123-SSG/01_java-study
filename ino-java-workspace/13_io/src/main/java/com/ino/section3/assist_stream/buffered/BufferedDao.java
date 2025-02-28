package com.ino.section3.assist_stream.buffered;

import java.io.*;

public class BufferedDao {
//    public void saveFile() {
//        BufferedWriter bw = null;
//        try {
//            bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
//            bw.write("hello.\n");
//            bw.write("nice to meet you.");
//            bw.newLine();
//            bw.write("come here.");
//            bw.write("come here.");
//            bw.write("come here.");
//            bw.write("come here.");
//            // 버퍼에 데이터가 쌓였다가 한번에 출력 -> 속도 향상
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (bw != null) {
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public void saveFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){
            String val = null;
            while ((val = br.readLine()) != null) {
                System.out.println(val);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cpFile() {
        File org = new File("C:\\dev\\env\\jdk-17.0.14_7", "NOTICE");
        File cp = new File("C:\\storage", org.getName());
        try (BufferedReader br = new BufferedReader(new FileReader(org));
        BufferedWriter bw = new BufferedWriter(new FileWriter(cp))){
            String val = null;
            while ((val = br.readLine()) != null) {
                bw.write(val + '\n');
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
