package com.kyungbae.section03.unchecked_checked;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Application2 {
    public static void main(String[] args) {
        // Checked Exception
        try {
            new URL("https://www.google.com");
        } catch (MalformedURLException e) {
            System.out.println("예외발생");
        }

        try {
            new File("text.txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
