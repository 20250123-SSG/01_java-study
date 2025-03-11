package com.ibe6.section03.assist_stream.object;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ObjectDao od = new ObjectDao();
//        od.fileSave();
        od.fileRead();
    }
}
