package com.john.section03.http_url_connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
    # HttpURLConnection
    - HTTP 프로토콜을 사용해서 웹 서버와 통신하기 위한 클래스
    - 웹 서버와의 연결을 관리함
    - 요청을 보내고 응답을 받는 기능 제공
 */
public class Application1 {
    public static void main(String[] args) {

        HttpURLConnection conn = null;
        try {
            URL url = new URL("https://www.naver.com");

            // # HttpURLConnection 인스턴스 생성(URL 인스턴스를 통해 생성)
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            /*
                ## (HTTP Response Code : 응답코드)
                - 200 : 정상
                - 4xx : request 문제 (클라이언트 측)
                - 5xx : 서버의 문제
             */

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode = " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("HTTP OK");
            }else{
                System.out.println("HTTP NOT OK");
            }

            /*
                # Content-Type(서버가 응답하는 콘텐츠의 MIME 타입)
                - 문서 타입 : text/xxx              ex) text/plain, text/html; charset=UTF-8
                - 이미지 타입 : image/xxx            ex) image/jpeg, image/png
                - 데이터 타입 : application/xxx      ex) application/xml, application/json
             */
            String contentType = conn.getContentType();
            System.out.println("contentType = " + contentType);
            
            /*
                # 요청 헤더 (Request Headers)
                - User-Agent        : 무엇으로 접속했는지에 대한 정보
                - Referer           : 이전 접속 주소 정보
                - Content-Type      : 컨텐트 타입
                - Content-Length    : 컨텐트 크기
             */

            String userAgent = conn.getRequestProperty("User-Agent");
            System.out.println("userAgent = " + userAgent);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(conn != null){
                conn.disconnect();
            }
        }
    }
}
