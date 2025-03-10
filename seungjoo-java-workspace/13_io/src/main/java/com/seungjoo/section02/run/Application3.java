package com.seungjoo.section02.run;

import com.seungjoo.section02.dto.Snack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application3 {
    public static void main(String[] args) {




        Properties prop = new Properties();
//        prop.put("다이제",new Snack("초코맛", 1500));
//
//        try { //담은 데이터를 저장시킬 때 사용
//            prop.store(new FileOutputStream("test.properties"), "propertiesTest");
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }

        //setProperty(String key, String value) 다음과 같은 속성의 value는 이거야
        prop.setProperty("List", "ArrayList");

        System.out.println(prop);
        try {
            prop.store(new FileOutputStream("test.peroperties"), "propertiesTest");

           prop.storeToXML(new FileOutputStream("test.xml"), "propertiesTest");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
