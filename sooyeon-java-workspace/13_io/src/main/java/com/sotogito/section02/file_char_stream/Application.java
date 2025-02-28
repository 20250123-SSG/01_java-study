package com.sotogito.section02.file_char_stream;

public class Application {
    public static void main(String[] args) {
        FileCharDao fileCharDAo = new FileCharDao();
        fileCharDAo.fileSave();
        fileCharDAo.fileRead();
    }
}
