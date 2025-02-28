package com.seungjoo.section02.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Application4 {
    public static void main(String[] args) {
        Properties prop = new Properties();// 텅 빈 상태

        try {
            prop.load(new FileInputStream("test.properties"));

            prop.loadFromXML(new FileInputStream("test.xml"));
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println(prop);
        System.out.println(prop.getProperty("List"));
    }
}
