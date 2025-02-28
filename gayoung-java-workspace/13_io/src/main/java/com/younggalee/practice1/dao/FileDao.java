package com.younggalee.practice1.dao;

import java.io.*;

public class FileDao {
    public void fileSave(String content, String fileName){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fileOpen(String fileName){
        // fileName매개변수 : 열고자 하는 파일명 (확장자 제외)
        String value = "";
        String line = "";

        try(BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"))) {
            while ((line = br.readLine()) != null) {
                value = value + line + "\n";
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 	그럴 경우는 null을 반환하도록 할 것
        // 해당 파일이 잘 찾아졌을 경우 BufferedReader로 읽어들여 문자열로 기록후
        return value;
    }
}
