package com.john.section03.http_url_connection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application3 {
    public static void main(String[] args) {
        HttpURLConnection conn = null;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        URL url = null;
        try {
            url = new URL("https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
            conn = (HttpURLConnection) url.openConnection();

            in = new BufferedInputStream(conn.getInputStream());
            out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\a\\Desktop\\test.png"));

            int readByte = 0;
            while ((readByte = in.read()) != -1) {
                out.write(readByte);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(out != null) {
                    out.close();
                }
                if(in != null) {
                    in.close();
                }
                if(conn !=null){
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
