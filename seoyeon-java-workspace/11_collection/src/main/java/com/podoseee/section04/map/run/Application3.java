package com.podoseee.section04.map.run;

import com.podoseee.section04.map.dto.Snack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application3 {
    public static void main(String[] args) {

        /*
            ## java.util.Properties ##

         */

        Properties prop = new Properties();

        /*
        prop.put("다이제", new Snack("초코맛", 1500));
        System.out.println(prop.get("다이제"));

        try {
            prop.store(new FileOutputStream("test.properties"), "propertiesTest");
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        // * setProperty(String key, String value)
        prop.setProperty("List", "ArrayList");
        prop.setProperty("Set", "HashSet");
        prop.setProperty("Map", "HashMap");
        prop.setProperty("Map", "Properties");

        System.out.println(prop);

        try {
            // * store(OutputStream os, String comment : Properties에 담겨있는 key-value3들을 문자열 변환해서 파일로 출력
            prop.store(new FileOutputStream("test.properties"), "propertiesTest");
            // * storeToXML(OutputStream os, String comment) : xml 파일로 저장시키고자 할 경우
            prop.storeToXML(new FileOutputStream("test.xml"), "propertiesTest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
