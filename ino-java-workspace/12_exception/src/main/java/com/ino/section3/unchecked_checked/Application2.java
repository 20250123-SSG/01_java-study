package com.ino.section3.unchecked_checked;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Application2 {
    public static void main(String[] args) {
        try {
            URL google = new URL("https://www.google.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            new File("test.txt").createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
