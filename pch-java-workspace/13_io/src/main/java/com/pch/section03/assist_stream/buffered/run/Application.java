package com.pch.section03.assist_stream.buffered.run;

import com.pch.section03.assist_stream.buffered.dao.BufferedDao;

public class Application {
    public static void main(String[] args) {
        BufferedDao dao = new BufferedDao();

        dao.fileSave();

        dao.fileRead();
    }
}
