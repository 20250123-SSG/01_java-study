package com.ibe6.section03.http_url_connection;

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

        try {
            URL url = new URL("https://www.naver.com");
            conn = (HttpURLConnection) url.openConnection();

            if(conn.getResponseCode() != 200){
                throw new RuntimeException("error code: " + conn.getResponseCode());
            }

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }

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
