package com.ino.section03.http_url_connection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Application3 {
    public static void main(String[] args) throws IOException {

        HttpURLConnection conn = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            URL url = new URL("https://google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
            conn = (HttpURLConnection) url.openConnection();
            bis = new BufferedInputStream(conn.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream("C:\\dev\\workspaces\\01_java-study\\ino-java-workspace\\16_network\\google-logo.png"));
            int readByte = 0;
            while((readByte = bis.read()) != -1) {
                bos.write(readByte);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) bos.close();
            if (bis != null) bis.close();
            if ( conn != null ) conn.disconnect();
        }
    }
}
