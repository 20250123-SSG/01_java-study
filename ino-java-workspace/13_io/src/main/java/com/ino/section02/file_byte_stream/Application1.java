package com.ino.section02.file_byte_stream;

import com.ino.section02.file_char_stream.FileCharDao;

public class Application1 {
    public static void main(String[] args) {
        FileByteDao fbd = new FileByteDao();
//        fbd.fileSave();
//        fbd.readFile();
        FileCharDao fcd = new FileCharDao();
//        fcd.fileSave();
        fcd.readFile();
    }
}
