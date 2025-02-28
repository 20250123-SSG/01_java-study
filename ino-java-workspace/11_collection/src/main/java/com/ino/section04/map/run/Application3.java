package com.ino.section04.map.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application3 {
    public static void main(String[] args) {

        Properties prop = new Properties();

        prop.setProperty("List", "ArrayList");
        prop.setProperty("Set", "HashSet");
        prop.setProperty("Map", "HashMap");

        System.out.println(prop);

        try {
            prop.store(new FileOutputStream("test.properties"), "propertiesTest");
            prop.storeToXML(new FileOutputStream("test.xml"), "propertiesTest");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
