package com.ino.section3.assist_stream.buffered;

import java.io.*;

public class Application {
    public static void main(String[] args) {
        BufferedDao bd = new BufferedDao();
//        bd.saveFile();
        bd.cpFile();
    }
}
