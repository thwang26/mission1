package com.example.test;

/* Java 1.8 샘플 코드 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
        /*URL*/
        urlBuilder.append("/" +  URLEncoder.encode("4668414e5568747734355a596d6b6e","UTF-8") );
        /*KEY*/
        urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") );
        /*TYPE*/
        urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8"));
        /*SERVICE*/
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8"));
        /*START_INDEX*/
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8"));
        /*END_INDEX*/
        // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/xml");
        System.out.println("Response code: " + conn.getResponseCode());
        /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
        BufferedReader rd;

        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}