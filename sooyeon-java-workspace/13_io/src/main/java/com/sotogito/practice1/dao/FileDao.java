package com.sotogito.practice1.dao;

import java.io.*;

public class FileDao {
    public void fileSave(String content, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt"))) {
            bw.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fileOpen(String fileName) {
        StringBuilder contents = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"))) {
            while (br.ready()) {
                contents.append(br.readLine()).append("\n");
            }
            return contents.toString();

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
