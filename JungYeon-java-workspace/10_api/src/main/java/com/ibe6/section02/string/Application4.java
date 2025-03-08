package com.ibe6.section02.string;

import org.w3c.dom.ls.LSOutput;

public class Application4 {
    public static void main(String[] args) {

        /*
            문자열을 관리하는 클래스 3가지
            ## java.lang.String ##
            1. 클래스지만 기본자료형 사용법 처럼 쓸 수 있음
            2. 불변클래스 (Immutable)
               : 기존에 참조하던 곳에서 변경 불가 (변경시마다 새로운곳을 참조하게됨)
            3. 변경이 빈번할 경우 매번 새로운 곳을 참조하게 되서 GC가 매번 삭제해야됨
               => 조회용으로 쓰면 좋음

            ## java.lang.StringBuilder|StringBuffer #
            1. 인스턴스를 생성한 후 메소드를 활용하여 사용해야됨
            2. 가변클래스
               : 기존에 참조하던 곳에서 변경 가능
            3. 변경이 빈번할 경우 사용하면 좋음
            4. 변경용 메소드를 메소드체이닝을 통해 사용할 수 있음
            5. StringBuilder와 StringBuffer의 차이점 (동기화 제공여부)
               * 동기화 : 하나의 자원(데이터)에 대해 여러 스레드(일의 단위)가 접근하려 할 때
                          한 시점에 하나의 스레드만 사용할 수 있도록 하는 것

              > StringBuilder : 동기화 제공 x => 속도가 빠름
              > StringBuffer  : 동기화 제공 o => 속도가 느림

              멀티스레드환경(여러개의 일처리가 동시다발적으로 수행되는 환경)
                   : 동기화가 제공되는걸로 해야 안전 => StringBuffer
              단일스레드환경(한번에 하나의 일만 처리하는 환경)
                   : 동기화가 필요없음 (되려 동기화가 제공되는걸로 하게되면 속도 저하) => StringBuilder

         */

        String str = "반가워!";
        System.out.println(System.identityHashCode(str));

        str += "난 String이야!"; // str = str + "난 String이야!";
        System.out.println(System.identityHashCode(str));
        // 주소값이 달라짐! == 새로운 곳을 참조 == 기존애 참조하던건 GC가 언잰가 지워줌

        System.out.println("=================");

        // StringBuilder 객체 생성시 처음에 16개의 문자들을 기록할 수 있는 버퍼가 내부적으로 생성
        StringBuilder sb = new StringBuilder("반가워!"); // 16 + 4글자
        System.out.println("sb: " + sb/*.toString()*/);
        System.out.println("주소값: " + System.identityHashCode(sb));
        System.out.println("수용량: " + sb.capacity()); // 16 + 4  == 20
        System.out.println("문자열의 길이: " + sb.length());

        System.out.println("====================");

        // * append(String) : 기존에 문자열 뒤에 인자로 전달된 새 문자열이 추가됨, 현재의 StringBuilder 주소값 반환
        sb.append("안녕!");

        System.out.println("변경후 sb: " + sb);
        System.out.println("주소값: " + System.identityHashCode(sb));
        System.out.println("수용량: " + sb.capacity());
        System.out.println("문자열의 길이: " + sb.length());
        // 주소값 변동 없음 == 기존에 참조하던 곳에서 변경 발생 == 가변클래스

        System.out.println("====================");

        sb.append("다들 조금만 힘내세요!!!"); // 14글자
        System.out.println("변경후 sb: " + sb);
        System.out.println("주소값: " + System.identityHashCode(sb));
        System.out.println("수용량: " + sb.capacity()); // 기존의 수용량 * 2 + 2
        System.out.println("문자열의 길이: " + sb.length());

        System.out.println("====================");

        // *delete(int, int) : 기존의 문자열로부터 start <= <end 번위의 문자열을 제거함, 현재 StringBuilder 주소값 반환
        sb.delete(2, 5); // 워   녕

        System.out.println("변경후 sb: " + sb);
        System.out.println("주소값: " + System.identityHashCode(sb));
        System.out.println("수용량: " + sb.capacity());
        System.out.println("문자열의 길이: " + sb.length());

        System.out.println("====================");

        // * insert(int, String) : 인자로 전달된 인덱스 위치에 전달된 문자열 추가됨, 현재 StringBuilder 주소값 반환
        sb.insert(1, "ㅎㅎㅎ");

        System.out.println("변경후 sb: " + sb);
        System.out.println("주소값: " + System.identityHashCode(sb));
        System.out.println("수용량: " + sb.capacity());
        System.out.println("문자열의 길이: " + sb.length());

        System.out.println("====================");

        // * reverse() : 기존의 문자열을 역순으로 바꿔줌, 현재 StringBuilde 주소값 반환
        sb.reverse();

        System.out.println("변경후 sb: " + sb);
        System.out.println("주소값: " + System.identityHashCode(sb));
        System.out.println("수용량: " + sb.capacity());
        System.out.println("문자열의 길이: " + sb.length());

        System.out.println("====================");

        sb.append("ㅋㅋㅋ").delete(0, 4).reverse().insert(2, "!!!");

        System.out.println("변경후 sb: " + sb);
        System.out.println("주소값: " + System.identityHashCode(sb));
        System.out.println("수용량: " + sb.capacity());
        System.out.println("문자열의 길이: " + sb.length());

        // 변경작업이 다 끝난 후엔 String 타입으로 기록
        String result = sb.toString();
        System.out.println(result);

        System.out.println("====================");

        performanceTest_String();
        performanceTest_StringBuilder();
    }

    public static void performanceTest_String() {
        // String을 이용한 문자열 연결(+ 연산자)

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String result = "";


        for (int i = 0; i < alphabet.length; i++) {
            result += alphabet[i];
        }
        long end = System.nanoTime();

        System.out.println("String 결과: " + result);
//        System.out.println("Spring의 소요시간: " + (end - start) + "ns");

    }

    public static void performanceTest_StringBuilder() {
        // StringBuilder를 이용한 문자열 연결 (append 메소드)
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        StringBuilder sb = new StringBuilder();

    for(int i = 0;
            i<alphabet.length; i++){
                sb.append(alphabet[i]);
            }

            long end = System.nanoTime();

    System.out.println("StringBuilder의 결과: "+sb);
//    System.out.println("StringBuilder의 소요시간: "+(end - start)+"ns");


    }
}