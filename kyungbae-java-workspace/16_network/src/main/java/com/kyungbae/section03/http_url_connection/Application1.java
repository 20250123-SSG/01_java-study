package com.kyungbae.section03.http_url_connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application1 {
    public static void main(String[] args) {

        // java.net.HttpURLConnection
        HttpURLConnection conn = null;
        try {
            // URL 인스턴스 생성
            URL url = new URL("https://www.naver.com/");

            // HttpURLConnection 인스턴스 생성
            conn = (HttpURLConnection) url.openConnection();

            /*
                접속 상태 (HTTP Response Code : 응답코드)
                1. 200 : 정상
                2. 4xx : 요청의 문제 (클라이언트측 문제)
                3. 5xx : 서버의 문제
             */
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                System.out.println("정상");
            } else {
                System.out.println("접속 불가");
            }

            /*
                Content-Type (서버가 응답하는 콘텐츠의 MIME 타입)
                1. 문서 타입   : text/xxx         ex) text/plain, text/html; charset=UTF-8
                2. 이미지 타입 : image/xxx        ex) image/jpeg
                3. 데이터 타입 : application/xxx  ex) application/xml

             */
            String contentType = conn.getContentType();
            System.out.println(contentType);

            /*
                요청 헤더 (Request Headers)
                1. User-Agent : 무엇으로 접속했는지에 대한 정보
                2. Referer : 이전 접속 주소 정보
                3. Content-Type : 컨텐트 타입
                4. Content-Length : 컨텐트 크기
             */
            String userAgent = conn.getRequestProperty("User-Agent");
            System.out.println(userAgent);
            userAgent = conn.getRequestProperty("Referer");
            System.out.println(userAgent);




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(conn != null){
                conn.disconnect(); // 접속 해제
            }
        }

    }
}
