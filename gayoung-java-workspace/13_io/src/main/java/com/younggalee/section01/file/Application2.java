package com.younggalee.section01.file;

import java.io.File;

public class Application2 {
    public static void main(String[] args) {
        // 1. 디렉토리 만들기
        // 1 ) File 인스턴스 생성
        File dir = new File("C:\\storage");

        // 2 ) 디렉토리가 존재할 경우 삭제 (이때, 해당 디렉토리는 비어 있어야 합니다. )
        if (dir.exists()) {
            // delete() : 삭제
            dir.delete();
        }
    }
}
