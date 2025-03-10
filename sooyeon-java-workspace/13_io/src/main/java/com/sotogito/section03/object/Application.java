package com.sotogito.section03.object;

public class Application {
    public static void main(String[] args) {
        ObjectDao dao = new ObjectDao();
        dao.fileSave();
        dao.fileRead();
    }
}
