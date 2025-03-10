package com.sotogito.section03.http_url_connection;

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
        BufferedInputStream in = null;
        BufferedOutputStream out = null;



        try {
            URL url = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
            conn = (HttpURLConnection) url.openConnection();

            in = new BufferedInputStream(conn.getInputStream());
            out = new BufferedOutputStream(new FileOutputStream("C:\\storage\\google.png"));

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
                if(in != null) in.close();
                if(out != null) out.close();
                if(conn != null) conn.disconnect();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
