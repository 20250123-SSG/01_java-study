package com.ibe6.section02.file_byte_stream;

public class Application {
    public static void main(String[] args) {
        /*
            ## 스트림(Stream) ##
            1. 자바 프로그램과 외부 매체간에 데이터를 전송할 수 있는 길(통로)
            2. 자바에서는 java.io 패키지에서 스트림 클래스들을 제공함 (계층구조로 되어있음)
            3. 특징
               1) 단방향   : 입력용 스트림과 출력용 스트림이 따로 존재함
               2) 선입선출 : FIFO, 먼저 전송한 데이터가 먼저 나가짐 => 시간지연(delay) 발생 가능
            4. 구분
               1) 용어
                  - 출력 스트림 : 프로그램 ----데이터---> 외부매체
                  - 입력 스트림 : 프로그램 <---데이터----> 외부매체
               2) 통로사이즈
                  - 바이트 스트림 : byte단위(1byte)로 데이터 전송 => 출력(OutPutStream)
                  - 문자 스트림 : byte단위(1byte)로 데이터 전송
               3) 외부매체와 직접 연결 여부
                  - 기본(기반) 스트링 : 외부매체와 직접 연결되는 스트림(필수)
                  - 보조(필터) 스트링 : 외부매체와 직접 연결되는 스트림x(선택)
                                        기본 스트림에 추가로 사용되는 스트림 ( 보조역할 수행, 추가기능 제공)
         */

        FileByteDao fbd = new FileByteDao();
//        fbd.fileSave();
        fbd.fileRead();
    }
}
