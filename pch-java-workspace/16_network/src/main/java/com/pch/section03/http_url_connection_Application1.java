package com.pch.section03;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class http_url_connection_Application1 {
    public static void main(String[] args) throws IOException {
        /*
            ## 요청 헤더 (Request Headers)
            1.  User-Agent  : 무엇으로 접속했는지
            2.  Referer     : 이전 접속 주소
            3.  Content-Type: 컨텐트 타입
            4.  Content-Length: 컨텐트 크기
         */



        URL url = new URL("https://www.naver.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        int responseCode = conn.getResponseCode();
        String userAgent = conn.getRequestProperty("User-Agent");
    }
}
