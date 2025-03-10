package com.kyungbae.section05.open_api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 한국환경공단_에어코리아_대기오염정보 > 시도별 실시간 측정정보 조회

        String serialKey = "Qr1f%2Bz%2BXwymFunXnlQIu3C%2FVPJbL2zBEPoJdEYO7E77uJt5aZ7iFsPmXgxWXc7LLT6K4Mq7vd%2F%2FFGA5Xcc4Ibg%3D%3D";

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try {

            // 1) 요청할 url
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
            urlBuilder.append("?serviceKey=" + serialKey);
            urlBuilder.append("&returnType=json");
            urlBuilder.append("&returnType=20");
            urlBuilder.append("&sidoName=" + URLEncoder.encode("경기", StandardCharsets.UTF_8));

//            System.out.println(urlBuilder.toString());

            // 2) HttpURLConnection 생성
            URL url = new URL(urlBuilder.toString());
            conn = (HttpURLConnection) url.openConnection();

            // 3) 응답데이터를 읽어들이기 위한 입력용 스트림 생성
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // 4) 응답데이터 읽어들이기
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null){
                sb.append(line);
            }
            String responseData = sb.toString();

//            System.out.println(responseData); // jsonString (json 구조의 문자열)

            // 5) 응답문자열 구문분석을 통해 처리 => JSONObject, JSONArray 객체 활용
            JSONObject obj = new JSONObject(responseData);
            JSONObject responseObj = obj.getJSONObject("response");
            JSONObject bodyObj = responseObj.getJSONObject("body");
            JSONArray itemsArr = bodyObj.getJSONArray("items");


            for (int i = 0; i < itemsArr.length(); i++) {
                JSONObject item = itemsArr.getJSONObject(i);
//                System.out.println(item);
                System.out.println("측정소명: " + item.getString("stationName"));
                System.out.println("일산화탄소 농도: " + item.getDouble("coValue"));
                System.out.println("오존 농도: " + item.get("o3Value"));
                System.out.println("미세먼지(PM10) 농도: " + item.get("pm10Value"));

                System.out.println("------------------------------------");
            }

            List<AirDto> list = new ArrayList<>();
            for (int i = 0; i < itemsArr.length(); i++) {
                JSONObject item = itemsArr.getJSONObject(i);

                String stationName = item.getString("stationName");
                double co = item.getDouble("coValue");
                Object o3 = item.get("o3Value");
                Object pm10 = item.get("pm10Value");

                list.add(new AirDto(stationName, co, o3, pm10));
            }
            list.forEach(System.out::println);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(in != null) in.close();
                if(conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
