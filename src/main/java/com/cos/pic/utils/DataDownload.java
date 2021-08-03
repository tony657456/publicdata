package com.cos.pic.utils;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class DataDownload {
        public static String getAirport() throws IOException {
                StringBuilder urlBuilder = new StringBuilder(
                                "http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*
                                                                                                                                * URL
                                                                                                                                */
                urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
                                + "=D20Z4JL1vaaXAYzfviSYg%2BPjV39hXfLAxPrIeJ3PsBoTvH00Y5gwSe%2FKyUrCwzb5vCs%2Bq%2Bee7BTB9CtpPeO43Q%3D%3D"); /*
                                                                                                                                             * Service
                                                                                                                                             * Key
                                                                                                                                             */
                urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
                                + URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
                urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
                                + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
                urlBuilder.append("&" + URLEncoder.encode("depAirportId", "UTF-8") + "="
                                + URLEncoder.encode("NAARKJJ", "UTF-8")); /* 출발공항ID */
                urlBuilder.append("&" + URLEncoder.encode("arrAirportId", "UTF-8") + "="
                                + URLEncoder.encode("NAARKPC", "UTF-8")); /* 도착공항ID */
                urlBuilder.append("&" + URLEncoder.encode("depPlandTime", "UTF-8") + "="
                                + URLEncoder.encode("20201201", "UTF-8")); /* 출발일 */
                urlBuilder.append("&" + URLEncoder.encode("airlineId", "UTF-8") + "="
                                + URLEncoder.encode("AAR", "UTF-8")); /* 항공사ID */
                urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
                URL url = new URL(urlBuilder.toString());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-type", "application/json");
                System.out.println("Response code: " + conn.getResponseCode());
                BufferedReader rd;
                if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
                return sb.toString();
        }
}
