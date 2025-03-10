package section04.map.run;

import section04.map.dto.Snack;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Application3 {
    /**
     * ## Properties
     * 1. Map을 구현하고 있는 클래스이므로 Map의 특징을 가지고 있음
     * 2. 주로 .properties 나 .xml파일로 입출력할 떄 사용
     * - key-value를 텍스트 형식으로 저장 가능
     * - 주로 프로그램의 환경설정 관련 내용을 작성해두고 자바 프로그램으로 해당 내용을 읽어 사용
     * => 환경설정 구문이 외부 파일에 기록되어있어 자바 코드를 수정할 필요 없이 파일만 열어 수정 가능
     * => 자바코드가 아니고 직관적으로 알아보기쉬운 파일이므로 일반인도 관리 쉬움
     * <p>
     * 위와같은 파일로 데이터를 입출력 할떄 String 으로 작업해야함
     */

    public static void main(String[] args) {
        Properties prop = new Properties();
//        prop.put("다이제", new Snack("초코", 1500)); //Snack의 경우는 자료형이 string이 아님 -> .ClassCastException
//        prop.put("칸쵸", new Snack("단맛", 600));
//        prop.put("새우깡", new Snack("짠맛", 500));
//        System.out.println(prop.get("다이제"));
//
//        try {
//            prop.store(new FileOutputStream("test.properties"),"pros test");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        prop.setProperty("List", "ArrayList");
        prop.setProperty("Map", "HashMap");
        prop.setProperty("Set", "HashMap");
        prop.setProperty("Map", "Properties");

        try {
            /// properties 확장자 파일 -> store()메서드 사용
            prop.store(new FileOutputStream("test.properties"), "prosTest"); //Set=HashMap

            /// xml 확장자 파일 -> storeToXml
            prop.storeToXML(new FileOutputStream("test.xml"), "proTest"); //<entry key="Set">HashMap</entry>

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
