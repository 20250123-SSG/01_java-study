package com.minkook.section01.file;

import java.io.File;
import java.io.IOException;

public class Application3 {
    public static void main(String [] args) throws IOException {
        File dir = new File("C:\\storage");

        //* exists() : 해당 디렉토리 및 파일의 존재 여부 반환
        //System.out.println(dir.exists());

        //2) 존재하지 않을 경우 생성
        if(!dir.exists()){

            // *mkdir() / mkdirs() : 디렉토리로 생성
            dir.mkdirs();
        }

        //2) 파일 생성
        File file = new File("C:\\storage\\test.txt");
        
        try {
            file.createNewFile(); //IOException 필수
        }catch (IOException e){
           e.printStackTrace();
       }

        //file.createNewFile(); //IOException 필수
    }
}
