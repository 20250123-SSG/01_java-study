package com.sotogito.section05.naver_api;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CaptchaController {
    private String clientId = "N7uwGdpRwIqzrS7jNmVw";
    private String clientSecret = "X2HNTvEu4c";

    public String getCaptchaKey() {
        String captchaKey = null;
        String url = "https://openapi.naver.com/v1/captcha/nkey";

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // JSONObject obj = new JSONObject(in.readLine());
            captchaKey = new JSONObject(in.readLine()).getString("key");


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) in.close();
                if (conn != null) conn.disconnect();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return captchaKey;
    }

    public void downloadCaptcha(String captchaKey) {
        String url = "https://openapi.naver.com/v1/captcha/ncaptcha.bin=" + captchaKey;
        HttpURLConnection conn = null;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedInputStream(conn.getInputStream());
            out = new BufferedOutputStream(new FileOutputStream("captcha.jpeg"));

            int readByte = 0;
            while ((readByte = in.read()) != -1) {
                out.write(readByte);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (conn != null) conn.disconnect();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void checkCaptcha(String captchaKey, String input) {
        String url = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + captchaKey + "&value=" + input;

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            JSONObject obj = new JSONObject(in.readLine());
            System.out.println(obj.getBoolean("result") ? "맞" : "틀");
            System.out.println(obj.getString("responseTime"));

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
