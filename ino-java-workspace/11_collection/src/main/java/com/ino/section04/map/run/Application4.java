package com.ino.section04.map.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application4 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        Properties prop2 = new Properties();

        try {
            prop.load(new FileInputStream("test.properties"));

            prop2.loadFromXML(new FileInputStream("test.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(prop.getProperty("Set"));
        System.out.println(prop2);
    }
}
