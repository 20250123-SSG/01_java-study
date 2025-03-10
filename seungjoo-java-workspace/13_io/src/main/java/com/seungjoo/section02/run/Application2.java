package com.seungjoo.section02.run;

import com.seungjoo.section02.file_char_stream.FileCharDao;

public class Application2 {
    public static void main(String[] args) {
        FileCharDao fileCharDao = new FileCharDao();
        fileCharDao.fileSave();
        fileCharDao.fileRead();

    }
}
