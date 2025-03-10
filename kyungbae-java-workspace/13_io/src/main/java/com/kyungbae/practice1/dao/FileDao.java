package com.kyungbae.practice1.dao;

import java.io.*;

public class FileDao {

    public void fileSave(String content, String fileName){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName+".txt"))) {

            bw.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("저장완");
    }

    public String fileOpen(String fileName){
        StringBuilder sb = new StringBuilder();
        String result = null;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName+".txt"))) {

            int value;
            while ((value = br.read()) != -1){
                sb.append((char)value);
            }
            sb.deleteCharAt(sb.length()-1);
            result = sb.toString();

        } catch (FileNotFoundException e) {
            result = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
