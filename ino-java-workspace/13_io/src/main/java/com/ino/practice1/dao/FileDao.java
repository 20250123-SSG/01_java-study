package com.ino.practice1.dao;

import java.io.*;

public class FileDao {

    public void fileSave(String content, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt"))) {
            bw.write(content);
            System.out.println(fileName + ".txt" + "파일에 성공적으로 저장하였습니다.");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fileOpen(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"))) {
            String input = "";
            while ((input = br.readLine()) != null) {
                sb.append(input);
                sb.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
