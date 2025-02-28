package com.kyungbae.section4.map.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Application4 {

    public static void main(String[] args) {
        Properties prts = new Properties();


        try {
            // load(InputSteam) : 파일에 기록된 key-value 를 읽어들여서 properties에 저장
            prts.load(new FileInputStream("test.properties"));

            // loadFromXML (InputStream) : xml 을 읽어들일 떄 사용
            prts.loadFromXML(new FileInputStream("test.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(prts);

        // getProperty(String key) : value를 String 타입으로 반환 (존재하지 않을 경우 null)
        System.out.println(prts.getProperty("Set"));
        System.out.println(prts.getProperty("set")); // null (오타, 대소문자 주의)

    }


}
