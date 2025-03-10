package com.pch.section05.naver_api;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CaptchaController {
    private String clientID = "oHV2PXpQ82XunwDHexjH";
    private String clientSecret = "Gn0HNy1a2V";

    public String getCaptchaKey() {
        String captchaKey = null;

        String url = "https://openapi.naver.com/v1/captcha/nkey";

        HttpURLConnection conn = null;
        BufferedReader br = null;

        try{

            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("X-Naver-Client-Id", clientID);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            captchaKey = new JSONObject(br.readLine()).getString("key");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (conn != null) conn.disconnect();
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

            // 요청 헤더 설정
            conn.setRequestProperty("X-Naver-Client-Id", clientID);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedInputStream(conn.getInputStream());
            out = new BufferedOutputStream(new FileOutputStream("captcha.jpeg"));

            int readBtye = 0;
            while((readBtye = in.read()) != -1){
                out.write(readBtye);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if (in != null) in.close();
                if (out != null) out.close();
                if (conn != null) conn.disconnect();

            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public boolean checkCaptcha(String captchaKey, String input){
        String url = "https://openapi.naver.com/v1/captcha/nkey?code=1&key="+captchaKey+"&value="+input;

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try{
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("X-Naver-Client-Id", clientID);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONObject obj = new JSONObject(in.readLine()); // { result : true/false, responseTime: String(초)}

            System.out.println(obj);

            System.out.println(obj.getBoolean("result"));
            System.out.println(obj.get("responseTime"));

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(in != null) in.close();
                if(conn != null) conn.disconnect();

            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return true;
    }
}
