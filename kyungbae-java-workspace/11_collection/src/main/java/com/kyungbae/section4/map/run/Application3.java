package com.kyungbae.section4.map.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application3 {
    public static void main(String[] args) {
        // java.map.Properties

        Properties prts = new Properties();

        /*
        prts.put("다이제", new Snack("초코맛", 1500));
        System.out.println(prts.get("다이제"));

        try {
            prts.store(new FileOutputStream("test.properties"), "propertiesTest");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        // prts.setProperty(String key, String value)
        prts.setProperty("List", "ArrayList");
        prts.setProperty("Set", "HashSet");
        prts.setProperty("Map", "HashMap");
        prts.setProperty("Map", "Properties");

        System.out.println(prts);

        try {
            // store(OpuStream os, String comment) : Properties 에 담겨있는 key-value 들을 문자열 변환해서 파일로 출력
            prts.store(new FileOutputStream("test.properties"), "propertiesTest");

            // storeToXML(OpuStream os, String comment) : .xml 파일로 저장시킬 경우 "OutputStream"으로만 가능
            prts.storeToXML(new FileOutputStream("test.xml"), "propertiesTest");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
