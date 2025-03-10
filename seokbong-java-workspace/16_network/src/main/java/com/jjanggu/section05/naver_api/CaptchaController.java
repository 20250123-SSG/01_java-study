package com.jjanggu.section05.naver_api;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CaptchaController {

    private String clientId = "t2fdRapu6zloIMTzAytq";
    private String clientSecret = "SKo36QcUTS";

    public String getCaptchaKey(){

        String captchaKey = null; // 발급된 키 기록

        String url = "https://openapi.naver.com/v1/captcha/nkey";

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try{

            conn = (HttpURLConnection) new URL(url).openConnection();

            // 요청헤더 설정
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

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

    public void downloadCaptchaImg(String captchaKey){

        String url = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + captchaKey;

        HttpURLConnection conn = null;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try{
            conn = (HttpURLConnection) new URL(url).openConnection();

            // 요청헤더 설정
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedInputStream(conn.getInputStream());
            out = new BufferedOutputStream(new FileOutputStream("captcha.jpeg"));

            int readByte = 0;
            while((readByte = in.read()) != -1 ){
                out.write(readByte);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(out != null) out.close();
                if(in != null) in.close();
                if(conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkCaptcha(String captchaKey, String input){

        String url = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + captchaKey + "&value=" + input;

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try{
            conn = (HttpURLConnection) new URL(url).openConnection();

            // 요청헤더 설정
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            JSONObject obj = new JSONObject(in.readLine()); // {result: true|false, responseTime : 초}

            System.out.println(obj.getBoolean("result") ? "맞았습니다!!" : "틀렸습니다ㅠㅠ");
            System.out.println(obj.get("responseTime") + "초");

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

    }


}
