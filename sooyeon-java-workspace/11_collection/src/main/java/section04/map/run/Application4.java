package section04.map.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Application4 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("test.properties"));

            prop.loadFromXML(new FileInputStream("test.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(prop);
        /// getProperty(String key) : value를  String 타입으로 반환 - 존재하지 않을 경우 null
        System.out.println(prop.getProperty("Set"));
    }
}
