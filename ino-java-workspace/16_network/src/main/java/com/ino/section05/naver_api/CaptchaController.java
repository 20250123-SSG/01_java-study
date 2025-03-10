package com.ino.section05.naver_api;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CaptchaController {
    private String cId = "nUf2a7iIh5JPB9IX_8Ku";
    private String cSecret = "qUbtRrc49u";

    public String getCaptchaKey() {
        String captchaKey = null;

        String url = "https://openapi.naver.com/v1/captcha/nkey";

        HttpURLConnection conn = null;
        BufferedReader br = null;

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Naver-Client-Id", cId);
            conn.setRequestProperty("X-Naver-Client-Secret", cSecret);
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            captchaKey = new JSONObject(br.readLine()).getString("key");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return captchaKey;
    }

    public void getCaptchaImage(String key) {
        String url = "https://openapi.naver.com/v1/captcha/ncaptcha.bin";

        HttpURLConnection conn = null;
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;

        try {
            conn = (HttpURLConnection) new URL(url + "?key=" + key).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Naver-Client-Id", cId);
            conn.setRequestProperty("X-Naver-Client-Secret", cSecret);
            bi = new BufferedInputStream(conn.getInputStream());

            bo = new BufferedOutputStream(new FileOutputStream("captcha.jpeg"));

            int n;
            while ((n = bi.read()) != -1) bo.write(n);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bi != null) bi.close();
                if (bo != null) bo.close();
                if (conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkCaptcha(String captchaKey, String input) {
        String url = "https://openapi.naver.com/v1/captcha/ncaptcha.bin";

        HttpURLConnection conn = null;
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;

        try {
            conn = (HttpURLConnection) new URL(url + "?key=" + captchaKey).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Naver-Client-Id", cId);
            conn.setRequestProperty("X-Naver-Client-Secret", cSecret);
            bi = new BufferedInputStream(conn.getInputStream());

            bo = new BufferedOutputStream(new FileOutputStream("captcha.jpeg"));

            int n;
            while ((n = bi.read()) != -1) bo.write(n);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bi != null) bi.close();
                if (bo != null) bo.close();
                if (conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
