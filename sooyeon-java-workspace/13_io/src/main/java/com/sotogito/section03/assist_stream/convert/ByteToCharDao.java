package com.sotogito.section03.assist_stream.convert;

import java.io.*;

public class ByteToCharDao {
    /**
     * ## 표준스트림
     * 1. 콘솔이나 키보드 같은 표준 입출력 장치로부터 데이터를 입출력하기 위한 스트림
     * 2. System 클래스의 in out err 필드에 해당하는 스트림
     * 3. 자주 사용하는 자원에 대해 미리 스트림 생성해둠
     * <p>
     * - System.in (InputStream) : 콘솔로부터 데이터 입력
     * - System.out (PrintStream) : 콘솔로 데이터 출력
     * - System.err (PrintStream) : 콘솔로 데이터 출력
     */


    public void standardStream() {
        try {
            System.out.println("입력 : ");
            int input = System.in.read();
            System.out.println(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ## InputStreamReader  OutputStreamReader
     * 1. 형변환 보조 스트림
     * 2. 바이트 기반 스트림을 문자 기반 스트림으로 변환시킬때 사용
     * 3. 보조 스트림에서 문자 스트림을 요구할 때 바이트 스트림을 문자 스트림으로 변환해서 사용
     *
     */

    /// 표준스트림 => BufferREader/BufferWriter. 보조스트림으로 성능향상
    public void consoleInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("입력 : ");
            String input = br.readLine();
            System.out.println(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void consoleOutput() {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            bw.write("ewffew");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}