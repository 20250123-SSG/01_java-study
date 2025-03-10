package com.john.section05.naver_api;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CaptchaController {

    private String clientId = "j6HC76FeKSaYwfFuaeke";
    private String clientSecret = "UYwusNe5DL";

    public String getCaptchaKey() {
        String captchaKey = "";
        String url = "https://openapi.naver.com/v1/captcha/nkey";

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            captchaKey = new JSONObject(in.readLine()).getString("key");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return captchaKey;
    }

    public void downloadCaptchaImage(String captchaKey) {
        String url = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + captchaKey;

        HttpURLConnection conn = null;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedInputStream(conn.getInputStream());

            out = new BufferedOutputStream(new FileOutputStream("captcha.jpg"));

            int readBytes = 0;
            while ((readBytes = in.read()) != -1) {
                out.write(readBytes);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void checkCaptcha(String captchaKey, String captchaInput) {
        String url = "https://openapi.naver.com/v1/captcha/nkey?code=1";
        StringBuilder sb = new StringBuilder();
        sb.append("&key=").append(captchaKey).append("&value=").append(captchaInput);


        HttpURLConnection conn = null;
        BufferedReader in = null;

        try {
            url += sb.toString();
            conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            JSONObject obj = new JSONObject(in.readLine());

            System.out.println(obj);
            System.out.println(obj.getBoolean("result") ? "맞음" : "아님");
            System.out.println(obj.get("responseTime") + "초");
            System.out.println(obj.getBigDecimal("responseTime") + "초");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
