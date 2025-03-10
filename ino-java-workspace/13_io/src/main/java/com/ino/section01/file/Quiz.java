package com.ino.section01.file;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.now;

public class Quiz {
    public static void main(String[] args) {
        LocalDate time = now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY\\MM\\dd");
        String formattedDay = dateTimeFormatter.format(time);

        File dir = new File("C:\\" + formattedDay);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}
