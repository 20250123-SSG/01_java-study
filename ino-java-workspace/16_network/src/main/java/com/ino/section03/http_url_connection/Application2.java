package com.ino.section03.http_url_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application2 {
    public static void main(String[] args) {

        HttpURLConnection conn = null;
        BufferedReader br = null;

        try {
            URL url = new URL("https://www.naver.com");
            conn = (HttpURLConnection) url.openConnection();

            int statusCode = conn.getResponseCode();

            if(statusCode != 200) {
                throw new RuntimeException("error code : " + statusCode);
            }

            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;

            while((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
