package com.sotogito.section03.assist_stream.buttered;

public class Applicaiton {
    public static void main(String[] args) {
        BufferedDao dao = new BufferedDao();
        dao.fileSave();
        dao.fileRead();
        dao.fileCopy();
    }

}
