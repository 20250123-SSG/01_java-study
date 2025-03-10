package com.sotogito.section05.open_api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //한국환경공단 에어코리아 대기오엽정보 시도별 실시간 특정 정보 조회
        String serviceKey = "BmyOBV9vZr%2BBXk%2FewqoiZiduawCkCIU0%2BrChRM5HQEtRtvSddF6os%2Bj3hPWPz4nP5y7Yqn5%2F5de8ZPWVdmBQkQ%3D%3D";

        HttpURLConnection conn = null;
        BufferedReader in = null;

        try {
            /// 1. 요청할 url 빌드
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
            urlBuilder.append("?serviceKey=").append(serviceKey);
            urlBuilder.append("&returnType=json");
            urlBuilder.append("&numOfRows=20");
            urlBuilder.append("&sidoName=").append(URLEncoder.encode("서울", "UTF-8"));


            /// 2. HttpURLConnection 생성
            URL url = new URL(urlBuilder.toString());
            conn = (HttpURLConnection) url.openConnection();

            /// 3. 응답데이터를 일겅들이기 위한 입력용 스트림 생성

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            /// 4. 응답데이터 읽어들이
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            String responseData = sb.toString();
            System.out.println(responseData); //jsonString (json구조의 문자열)

            ///  5. 응답문자열 구문분석을 통해 처리 -> JSONject, JSONArray 객체 활용
            /**
             * ## JSON
             * 1. JavaScript Object Notation
             * 2. JavaScript의 객체를 토대로 개발한 데이터 형식
             * 3. 데이터 전송을 위한 표준 형식 중 하나로 주로 경량데이터 처리할 때 사용
             * 4. name:value 의 조합으로 데이터를 구성함
             * 5. 자바에서 JSON데이터를 취급하기 위해 JSON 라이브러리 필요
             *      1) https://www.json.org
             *      2) 제공 주요 클래스
             *          - JSONObject : {key:value, key:value, ...}
             *          - JSONArray : [value, value, value, ...]
             *      3) 제공 주요 메서드
             *          - getJSONObject : 해당 key,value를 JSONObject로 반환
             *          - getJSONArray(key) : 해당 key, value를 JSONArray 객체로 반환
             *          - getString(key) : '' String으로 반환
             *          - getDouble(key)
             *          - get(key)
             */
            JSONObject obj = new JSONObject(responseData); ///{response : {body: {items: [{}, {}, ...]}}}
            JSONObject responseObj = obj.getJSONObject("response"); ///{body: {items: [{}, {}, ...]}}
            JSONObject bodyObj = responseObj.getJSONObject("body"); /// {items: [{}, {}, ...]}
            JSONArray itemArr = bodyObj.getJSONArray("items"); /// [{}, {}, ...]

            List<AirDto> list = new ArrayList<>();

            for (int i = 0; i < itemArr.length(); i++) {
                JSONObject item = itemArr.getJSONObject(i);
                list.add(new AirDto(
                        item.getString("stationName"),
                        item.getDouble("coValue"),
                        item.getDouble("o3Value"),
                        item.getInt("pm10Value")
                ));
            }

            list.forEach(System.out::println);


        } catch (UnsupportedEncodingException | MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) in.close();
                if (conn != null) conn.disconnect();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
