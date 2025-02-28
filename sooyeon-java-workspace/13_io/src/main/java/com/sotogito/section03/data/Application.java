package com.sotogito.section03.data;

public class Application {
    public static void main(String[] args) {
        DataDao dao = new DataDao();
        dao.fileSave();
        dao.fileRead();
    }
}
