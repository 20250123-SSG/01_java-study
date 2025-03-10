package com.jjanggu.section03.http_url_connection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application3 {
    public static void main(String[] args) {

        HttpURLConnection conn = null;

        BufferedInputStream in = null;      // 이미지 데이터를 읽어들이기 위한 스트림
        BufferedOutputStream out = null;    // 이미지 데이터를 저장시키기 위한 스트림

        try {
            URL url = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
            conn = (HttpURLConnection) url.openConnection();

            in = new BufferedInputStream(conn.getInputStream());
            out = new BufferedOutputStream(new FileOutputStream("C:\\storage\\google-logo.png"));

            int readByte = 0;
            while((readByte = in.read()) != -1){
                out.write(readByte);
            }

        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(out != null) out.close();
                if(in != null) in.close();
                if(conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}