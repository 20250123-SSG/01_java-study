package com.ino.section05.open_api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        HttpURLConnection conn = null;
        BufferedReader br = null;

        String serviceKey = "sH8S1Rs8Z3zwui7KUekkIH5T4LZCtnu9JRFVJvPTS%2FAn6p0IukSP82RHAE8CONI74UI1GGhZ2DdiBFicSzEIlw%3D%3D";

        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
            urlBuilder.append("?serviceKey=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
            urlBuilder.append("&sidoName=" + URLEncoder.encode("서울", "UTF-8"));
            URL url = new URL(urlBuilder.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println(sb.toString());
            JSONObject obj = new JSONObject(sb.toString());
            JSONObject responseObj = obj.getJSONObject("response");
            JSONObject bodyObj = responseObj.getJSONObject("body");
            JSONArray itemsArr = bodyObj.getJSONArray("items");

            List<AirDto> list = new ArrayList<>();
            for (int i = 0; i < itemsArr.length(); i++) {
                JSONObject object = itemsArr.getJSONObject(i);
                String stationName = object.getString("stationName");
                double co = object.getDouble("coValue");
                double o3 = object.getDouble("o3Value");
                int pm10 = object.getInt("pm10Value");

                list.add(new AirDto(stationName, co, o3, pm10));
                list.forEach(System.out::println);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    if (conn != null) conn.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

