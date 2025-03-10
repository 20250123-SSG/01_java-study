package com.ino.section03.http_url_connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application1 {
    public static void main(String[] args) {
        HttpURLConnection conn = null;
        try {

            URL url = new URL("https://www.naver.com");

            conn = (HttpURLConnection) url.openConnection();

            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("정상 접속");
            }else {
                System.out.println("접속 불가");
            }

            String contentType = conn.getContentType();
            System.out.println(contentType);

            System.out.println(conn.getRequestProperty("User-Agent"));
            System.out.println(conn.getRequestProperty("Referer"));
            System.out.println(conn.getRequestProperty("Content-Type"));
            System.out.println(conn.getRequestProperty("Content-Length"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                conn.disconnect();
            }
        }
    }
}
