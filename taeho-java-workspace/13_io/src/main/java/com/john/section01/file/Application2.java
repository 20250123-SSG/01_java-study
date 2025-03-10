package com.john.section01.file;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Application2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String dateFormat = DateTimeFormatter.ofPattern("yyyy\\MM\\dd").format(date);
        File dir = new File("C:\\dev\\workspace\\01_java-study\\taeho-java-workspace\\13_io\\"+ dateFormat);

        if (dir.exists()) {
            dir.delete();
        }

        System.out.println(dir.exists());
    }
}
