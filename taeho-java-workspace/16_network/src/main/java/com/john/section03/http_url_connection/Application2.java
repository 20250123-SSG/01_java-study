package com.john.section03.http_url_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application2 {
    public static void main(String[] args) {
        HttpURLConnection conn = null;
        BufferedReader in = null;

        URL url = null;
        try {
            url = new URL("https://www.naver.com");
            conn = (HttpURLConnection) url.openConnection();

            if(conn.getResponseCode() != 200){
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            in = new BufferedReader((new InputStreamReader(conn.getInputStream())));

            String line = null;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                conn.disconnect();
            }
        }
    }
}
