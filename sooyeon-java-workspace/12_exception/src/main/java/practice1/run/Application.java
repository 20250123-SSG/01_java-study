package practice1.run;

import practice1.controller.NamingTest;
import practice1.exception.NamingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NamingTest nt = new NamingTest();

        try {
            System.out.println("변수명으로 쓸 문자열을 쓰시오 : ");
            String variableName = br.readLine().trim();

            if (nt.isReservedWord(variableName) &&
                    nt.isSpecialWord(variableName) &&
                    nt.isNumFirst(variableName)) {

                System.out.println("ㅇㅋ");
            }

        } catch (NamingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("다시입력하세요.");
        }
    }

}
