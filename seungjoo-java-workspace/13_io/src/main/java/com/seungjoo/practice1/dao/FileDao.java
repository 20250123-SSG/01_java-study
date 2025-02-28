package com.seungjoo.practice1.dao;

import com.seungjoo.section03.assist_stream.BufferedDao;

import java.io.*;

public class FileDao {


    public void fileSave(String content, String fileName) {
        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new FileWriter(fileName + "txt"));

            bw.write(content);
            bw.flush();



        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
    }
    public String fileOpen(String fileName) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(fileName + "txt"));

            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }


}
