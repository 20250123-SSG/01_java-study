package com.podoseee.practice1.dao;

import java.io.*;

public class FileDao {

    public void fileSave(String content, String fileName) {
        // content매개변수 : 저장시키고자 하는 파일 내용
        String contentToSave = content;
        // fileName매개변수 : 저장시킬 파일의 이름 (확장자 제외)
        String FullFileName = fileName;
        // 전달된 파일 내용을 전달된 파일명으로 저장시키기 (이때 확장자는 .txt로 할 것)
        // BufferedWriter, FileWriter 이용해서 하기
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FullFileName))) {
            bw.write(contentToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fileOpen(String fileName) {
        // fileName매개변수 : 열고자 하는 파일명 (확장자 제외)
        String FullFileName = fileName;
        StringBuilder content = new StringBuilder();

        // BufferedReader, FileReader 이용해서 하기
        // 해당 전달된 파일명의 파일내용을 읽어 들여서 반환하기
        // 이때 파일의 확장자는 .txt로 해서 찾기
        // 만일 존재하지 않는 파일명일 경우 어떤 예외가 발생될지 예상해서
        // 그럴 경우는 null을 반환하도록 할 것
        try(BufferedReader br = new BufferedReader(new FileReader(FullFileName))) {
            String line;
            while ((line = br.readLine()) != null){
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // 해당 파일이 잘 찾아졌을 경우 BufferedReader로 읽어들여 문자열로 기록후 반환
        return content.toString();
    }
}
