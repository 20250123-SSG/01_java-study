package com.sotogito.section03.http_url_connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application1 {
    public static void main(String[] args) {
        /**
         * ## HttpURLConnection
         * 1. HTTP 프로토콜을 사용해서 웹 서버와 통신하기 위한 클래스
         * 2. 웹 서버와 연결을 관리함
         * 3. 요청을 보내고 응답을 받는 기능 제공
         */

        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://www.google.com/oqwijoiwefjowiejfowiejflaknlwenvawieuvliauwhefiuahefliuhawelifuhldkjfhewhfeuf");

             conn = (HttpURLConnection) url.openConnection();
            int responseCode = conn.getResponseCode(); //응답코드

            if(responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("HTTP OK");
            }else {
                System.out.println("HTTP NOT OK");
            }
            /**
             * 접속 상태
             * 1. 200 : 정상
             * 2/ 4XX : 요청의 문제
             */


            /**
             * ## Content-Type 서버가 응답하는 콘텐츠 MIME타입
             * 1. 문서타입 : text/xxx
             * 2. 이미지 타입 : image/xxx
             * 3. 데이터 타입 : application/xxx
             */
            String contentType = conn.getContentType();
            System.out.println("Content-Type: " + contentType);

            /**
             * 요청 헤더
             * 1. User-Agent : 무엇으로 접속했는지에 대한 정보
             * 2. Referer : 이전 접속 주소 정보
             * 3. Content-Type : 컨텐트 타입
             * 4. Content-Length : 컨텐트 크기
             */

            String userAgent = conn.getRequestProperty("User-Agent");
            System.out.println("User-Agent: " + userAgent);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(conn != null){
                conn.disconnect();
            }
        }
    }
}
