package com.kyungbae.section05.naver_api;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CaptchaController {

    private final String clientId = "woSIGaSF7HklsdSLT6bN";
    private final String clientSecret = "ASn8hKqxQA";

    // 캡차 키 발급 method
    public String getCaptchaKey(){
        String captchaKey = null; // 발급된 키 기록

        // 요청 URL
        String url = "https://openapi.naver.com/v1/captcha/nkey";

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();

            // 요청헤더 설정
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            // 요청 => JSON 방식으로 입력
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // 들어온 방식에서 key만 추출
            captchaKey = new JSONObject(in.readLine()).getString("key");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(in != null) in.close();
                if(conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return captchaKey;
    }

    // 캡차 이미지 받기 (캡차키 입력) => 다운로드
    public void downloadCaptchaImg(String captchaKey){

        // 파라미터 : key
        String url = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + captchaKey;

        HttpURLConnection conn = null;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();

            // 요청헤더 설정
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedInputStream(conn.getInputStream());
            out = new BufferedOutputStream(new FileOutputStream("captcha.jpeg"));

            // 파일 다운로드
            int readByte = 0;
            while ((readByte = in.read()) != -1) {
                out.write(readByte);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(out != null) out.close();
                if(in != null) in.close();
                if(conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 입력값과 캡차 검증
    public void checkCaptcha(String captchaKey, String input){

        String url = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + captchaKey + "&value=" + input;

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try{
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            JSONObject obj = new JSONObject(in.readLine());
            // ex) {"result":true,"responseTime":84.6} 으로 출력되는 것 받기

            System.out.println(obj.getBoolean("result") ? "성공" : "탈락");
            System.out.println(obj.get("responseTime") + "초");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(in != null) in.close();
                if(conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
