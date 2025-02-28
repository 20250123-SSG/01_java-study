package com.younggalee.section03.assist_stream.data;

public class Application {
    public static void main(String[] args) {
        DataDao dd = new DataDao();
        dd.fileSave();
        dd.fileRead();
        // 깊이있는 한장!
    }
}
