package com.minkook.section03.http_url_connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application1 {
    public static void main(String [] args){
       /*
            ## java.net.HttpURLConnection
            1. Http 프로토콜을 사용해서 웹 서버와 통신하기 위한 크랠스
            2. 웹 서버와의 연결을 관리함
            3. 요청을 보내고 응답을 받는 기능 제공
        */
        URL url = null;
        try {
            url = new URL("https://www.naver.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();



            /*
                ## 접속상태 (응답코드)
                1. 200 : 정상
                2. 4xx : 요청의 문제 (클라이언트 측 문제)
                3. 5xx : 서버의 문제
             */

            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
            
            if(responseCode == 200){
                System.out.println("정상 접속");
            }else {
                System.out.println("접속 불가");
            }

            /*
                 ## Content_Type(서버가 응답하는 콘텐츠의 MIME 타입)
                 1. 문서타입 : text/xxx
                 2. 이미지타입: image/xxx
             */

            String contentType = conn.getContentType();
            System.out.println(contentType);


            String userAgent = conn.getRequestProperty("User-Agent");
            System.out.println(userAgent);
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
