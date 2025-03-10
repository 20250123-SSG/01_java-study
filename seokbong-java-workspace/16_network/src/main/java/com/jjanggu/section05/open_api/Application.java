package com.jjanggu.section05.open_api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 한국환경공간_에터코리아_대기오염정보 > 시도별 실시간 축정정보 조회

        String serviceKey = "z3D10Y4iuMZTN2QckEFW2l4oNoFYHoTu0Jzl4yarZ1CZ%2Bri4NOz0nW6o%2B22Ys5OXqktGeEXrdZt%2F%2B8%2F6oJEe8w%3D%3D";
        HttpURLConnection conn = null;
        BufferedReader in = null;



        // 1) 요청할 url

        try {
            StringBuilder urlBuilder = new StringBuilder( " http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
            urlBuilder.append("?serviceKey=" + serviceKey);
            urlBuilder.append("&returnType=json");
            urlBuilder.append("&numOfRows=20");
            urlBuilder.append("&sidoName=" + URLEncoder.encode("서울", "UTF-8"));

            //System.out.println(urlBuilder.toString());

            // 2) HttpURLConnection 생성
            URL url = new URL(urlBuilder.toString());
            conn =(HttpURLConnection) url.openConnection();

            // 3) 응답데이터를 읽어들이기 위한 입력용 스트림 생성
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // 4) 응답데이터 읽어들이기
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = in.readLine()) != null){
                sb.append(line);
            }
            String responseData = sb.toString();

            //System.out.println(responseData); // jsonString (json 구조의 문자열)

            // 5) 응답문자열 구문분석을 통해 처리 => JSONObject, JSONArray 객체 활용
            /*
                ## JSON ##
                1. JavaScript Object Notation
                2. JavaScript의 객체를 토대로 개발한 데이터 형식
                3. 데이터 전송을 위한 표준 형식 중 하나로 주로 경량데이터 처리할 때 사용
                4. name:value 의 조합으로 데이터를 구성함
                5. 자바에서 JSON 데이터를 취급하기 위해 JSON 라이브러리 필요 (JSON-java)
                   1) https://www.json.org
                   2) 제공 주요 클래스
                      - JSONObject  : {key:value , key:value, ..}
                      - JSONArray   : [value, value, value, ...]
                   3) 제공 주요 메소드
                      - getJSONObject(key) : 해당 key의 value를 JSONObject 객체로 반환
                      - getJSONArray(key)  : 해당 key의 value를 JSONArray 객체로 반환
                      - getString(key)     : 해당 key의 value를 String 으로 반환
                      - getInt(key)
                      - getDouble(key)
                      - get(key)           : 해당 key의 value를 Object 으로 반환
             */

            JSONObject obj = new JSONObject(responseData);          // { response:{ body:{ items:[ {}, {}, .. ] } } }
            JSONObject responseObj = obj.getJSONObject("response"); //            { body:{ items:[ {}, {}, .. ] } }
            JSONObject bodyObj = responseObj.getJSONObject("body"); //                   { items:[ {}, {}, .. ] }
            JSONArray itemsArr = bodyObj.getJSONArray("items");     //                           [ {}, {}, .. ]

            /*
            for(int i = 0; i < itemsArr.length(); i++){
                JSONObject item = itemsArr.getJSONObject(i); // {pm10Value:xx, stationName: "xxx" , o3Value:xx}
                //System.out.println(item);
                System.out.println("측정소명 : " + item.getString("stationName"));
                System.out.println("일산화탄소 농도 : " + item.getDouble("coValue"));
                System.out.println("오존 농도 : " + item.getDouble("o3Value"));
                System.out.println("미세먼지(PM10) 농도 : " + item.getInt("pm10Value"));

                System.out.println("==============================");
            }
             */

            List<AirDto> list = new ArrayList<>();
            for(int i = 0; i < itemsArr.length(); i++){
                JSONObject item = itemsArr.getJSONObject(i);

                String station = item.getString("stationName");
                double co = item.getDouble("coValue");
                double o3 = item.getDouble("o3Value");
                int pm10 = item.getInt("pm10Value");

                list.add(new AirDto(station, co, o3, pm10 ));
            }
            //System.out.println(list);
            list.forEach(System.out::println);


        } catch (UnsupportedEncodingException | MalformedURLException e) {
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
