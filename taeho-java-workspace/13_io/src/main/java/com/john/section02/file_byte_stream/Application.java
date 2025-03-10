package com.john.section02.file_byte_stream;

import java.io.FileInputStream;

/*
    Stream
    - 자바 프로그램과 외부 매체 간에 데이터를 전송할 수 있는 길
    - 자바에서는 java.io 패키지에서 스트림 클래스들을 제공함(계층 구조)
    - 특징
        - 단방향    :입력용 스트림과 출력용 스트림이 따로 존재
        - 선입선출  :FIFO => 시간지연 발생 가능
    - 통로 사이즈
        - 바이트 스트림: byte(1byte) 단위로 데이터 전송 => 출력(OutputStream) / 입력(InputStream)
        - 문자 스트림: char(2byte) 단위로 데이터 전송 => 출력(Writer) / 입력(Reader)
    - 외부매체와 직접 연결 여부
        - 기본 스트림 : 외부매체와 입출력을 진행할건지 정하는 스트림
        - 보조 스트림 : 기반 스트림을 보조 역할하는 스트림
 */
public class Application {
    public static void main(String[] args) {
        FileByteDao fbd = new FileByteDao();
        fbd.fileSave();
        fbd.fileRead();
    }
}
