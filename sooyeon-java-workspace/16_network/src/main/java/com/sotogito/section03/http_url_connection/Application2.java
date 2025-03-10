package com.sotogito.section03.http_url_connection;

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
            URL url = new URL("http://www.naver.com");
            conn = (HttpURLConnection) url.openConnection();

            if(conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

           in = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            while(in.ready()) {
                System.out.println(in.readLine());
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(in != null) in.close();
                if(conn != null) conn.disconnect();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
