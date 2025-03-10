package com.podoseee.section04.map.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Application4 {
    public static void main(String[] args) {
        Properties prop = new Properties(); // 텅빈상태

        try {
            // * load(InputStream) : 파일에 기록된 key-value를 읽어들여서 Properties에 저장
            prop.load(new FileInputStream("test.properties"));

            // * loadFromXML(InputStream) : xml을 읽어들일 때 사용
            prop.loadFromXML(new FileInputStream("test.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(prop);

        // * getProperty(String key) : value를 String 타입으로 반환 (존재하지 않을 경우 null 반환)
        // 오타 많이 나니까 key값 복사해서 쓰기

        System.out.println(prop.getProperty("Set"));
        System.out.println(prop.getProperty("Set")); // null
        System.out.println(prop.getProperty("selectMemberList"));
    }
}
