package com.john.section04.map.run;

import com.john.section04.map.dto.Snack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
    Properties
    - Map을 구현하고 있는 클래스
    - Properties 내 데이터를 .properties 또는 .xml파일로 입출력시 사용
    - 키, 밸류를 택스트 형태로 작성해둘 수 있는 파일
    - 주로 프로그램의 환경설정(ip주소, db경로 등)관련 내용을 작성해두고
      자바 프로그램상으로 해당 내용을 읽어들여서 사용
        => 환경설정 구문이 외부 파일에 기록되어있어 자바코드를 수정할 필요없이 파일 수정
        => 직관적으로 알아보기 쉬운 파일로 일반인도 관리 가능
    - 키, 밸류를 String으로 작업 => setProperty(), get Property()메서드를 주로 사용
 */
public class Application3 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        // setProperty(String key, String value)
        prop.setProperty("name", "John");
        prop.setProperty("age", "25");
        prop.setProperty("Set", "HashSet");
        prop.setProperty("List", "ArrayList");
        prop.setProperty("Map", "HashMap");
        prop.setProperty("Map", "Properties");
        System.out.println(prop);
        try {
            //store(OutputStream os, String comment): Properties에 담겨있는 key-value들을 문자열 변환해서 파일로 출력
            prop.store(new FileOutputStream("test.properties"),"TEST description");

            // xml출력시 storeToXML(OutputStream os, String comment)
            prop.storeToXML(new FileOutputStream("testxml.xml"), "TEST description");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
