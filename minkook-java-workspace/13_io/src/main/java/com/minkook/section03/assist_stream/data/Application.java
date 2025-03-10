package com.minkook.section03.assist_stream.data;

import javax.xml.crypto.Data;

public class Application {
    public static void main(String [] args){
        DataDao dd = new DataDao();
        //dd.fileSave();
        dd.fileRead();
    }
}
