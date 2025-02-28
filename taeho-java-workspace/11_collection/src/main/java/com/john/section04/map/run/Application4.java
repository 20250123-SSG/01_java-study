package com.john.section04.map.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Application4 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        //Read properties File
        try {
            // load(InputStream): 파일에 기록된 key-value를 읽고 Properties에 저장
            prop.load(new FileInputStream("test.properties"));
            
            // loadFromXML(InputStream): xml을 읽을 때 사용
            prop.loadFromXML(new FileInputStream("testxml.xml"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // 키 값이 같은 경우 덮어씌워짐
        System.out.println(prop);
        // 없는 경우 null return
        System.out.println(prop.getProperty("ip"));
        System.out.println(prop.getProperty("value"));
    }
}
