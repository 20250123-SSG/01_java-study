package com.seungjoo.section01.file;

import java.io.File;

public class Application2 {
    public static void main(String[] args) {
        //2. 디렉토리 삭제(단, 비어있는 디렉토리만 삭제 가능)

        //1) File 인스턴스 생성
        File dir = new File("/Users/eun07213/storage");

        if(dir.exists()){ //디렉토리가 존재할 경우 삭제
            dir.delete();
        }
    }

}
