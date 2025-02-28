package com.john.section03.assist_stream.convert;

import java.io.*;

/*
    표준 스트림
    1. 콘솔이나 키보드 같은 표준 입출력 장치로부터 데이터를 입출력하기 위한 스트림
    2. System클래스의 in out err 필드에 해당하는 스트림
    3. 종료
        - System.in (InputStream)
        - System.out(PrintStream)
        - System.err(PrintStream)
        => 자주 사용되는 자원에 대해 미리 스트림을 생성해둬, 개발자가 별도로 생성하지 않아도 됨

    InputStreamReader / OutputStreamWriter
        1. 형변환 보조 스트림
        2. 바이트 기반 스트림을 문자 기반 스트림으로 변환 시킬때 사용
        3. 주로 보조스트림에서 문자스트림을 요구할 때 변환용로 사용
 */
public class ByteToCharDao {

    public void standardStream() {
        try {
            System.out.print("입력: ");
            int input = System.in.read();
            System.out.println((char) input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void consoleInput() {
        //System.in => InputStream(바이트스트림) => Reader(문자스트림으로 변환)
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("입력: ");
            String input = br.readLine();
            System.out.println("input : " + input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void consoleOutput() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write("java oracle jdbc");
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
