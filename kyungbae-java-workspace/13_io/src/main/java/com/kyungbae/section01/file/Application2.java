package com.kyungbae.section01.file;

import java.io.File;

public class Application2 {
    public static void main(String[] args) {

        // 2. 디렉토리 삭제 (비어있는 디렉토리만)

        // 1) File 인스턴스 생성
        File dir = new File("C:\\storage");

        // 2) 디렉토리가 존재할 경우 삭제
        if (dir.exists()){
            // delete() : 디렉토리 및 파일 삭제
            dir.delete();
        }

        System.out.println(dir.exists());

    }
}
