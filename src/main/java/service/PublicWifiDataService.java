package service;

import com.google.gson.*;
import domain.WifiInfoDTO;
import repository.WifiInfoDAO;
import repository.WifiInfoDAOImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

/** 공공 와이파이 데이터 저장 class */
public class PublicWifiDataService {
    /** 지정한 인덱스 범위만큼의 데이터 api 요청 */
    public JsonObject getApi(int startIdx, int endIdx) throws IOException {
        String urlBuilder = "http://openapi.seoul.go.kr:8088" + "/" + URLEncoder.encode("4668414e5568747734355a596d6b6e", "UTF-8") +
                "/" + URLEncoder.encode("json", "UTF-8") +
                "/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8") +
                "/" + URLEncoder.encode(String.valueOf(startIdx), "UTF-8") +
                "/" + URLEncoder.encode(String.valueOf(endIdx), "UTF-8");

        URL url = new URL(urlBuilder);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/xml");
        BufferedReader rd;

        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        JsonObject jsonObject = (JsonObject)JsonParser.parseReader(rd);
        rd.close();
        conn.disconnect();

        return (JsonObject)jsonObject.get("TbPublicWifiInfo");
    }

//    public List<JsonArray> getApiJsonArrays() throws IOException {
//        List<JsonArray> jsonArrays = new ArrayList<>();
//        int startIdx = 1;
//        int endIdx = 1000;
//        final int range = 1000;
//
//        while (true) {
//            JsonArray jsonArray = getApi(startIdx, endIdx);
//            if (jsonArray == null) {
//                break;
//            } else {
//                jsonArrays.add(jsonArray);
//                startIdx += range;
//                endIdx += range;
//            }
//        }
//
//        return jsonArrays;
//    }

    /** 멀티스레드+반복문으로 api 에게 모든 데이터 요청 */
    public List<JsonArray> getApiJsonArrays() throws IOException {
        List<JsonArray> jsonArrays = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        int totalCount = getApi(1, 1).get("list_total_count").getAsInt();
        // 총 데이터의 개수
        int startIdx = 1;
        int endIdx = 1000;
        final int range = 1000;

        do {
            int finalStartIdx = startIdx;
            int finalEndIdx = endIdx;

            Thread thread = new Thread(() -> {
                try {
                    JsonArray jsonArray = (JsonArray) getApi(finalStartIdx, finalEndIdx).get("row");
                    synchronized (jsonArrays) {
                        if (!jsonArray.isJsonNull()) {
                            jsonArrays.add(jsonArray);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            threads.add(thread);
            thread.start();

            startIdx += range;
            endIdx += range;

        } while (startIdx < totalCount);

        // 모든 스레드가 작업을 완료할 때까지 대기
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return jsonArrays;
    }

    /** Json -> DTO 파싱 후 위경도 보정 호출 */
    public List<WifiInfoDTO> mapJsonToDTO(List<JsonArray> jsonArrays) {
        List<WifiInfoDTO> wifiInfoDTOList = new ArrayList<>();

        for (JsonArray jsonArray: jsonArrays) {
            for (JsonElement jsonElement: jsonArray) {
                if (!jsonElement.isJsonNull()) {
                    WifiInfoDTO wifiInfoDTO = new Gson().fromJson(jsonElement, WifiInfoDTO.class);
                    wifiInfoDTOList.add(geoCalibrate(wifiInfoDTO));
                }
            }
        }

        return wifiInfoDTOList;
    }

    /** 위경도 값이 잘못되었을 시 보정 해 주는 작업
     위경도 값이 없으면(0이라면) 보정하지 않음) */
    public WifiInfoDTO geoCalibrate(WifiInfoDTO wifiInfoDTO) {
        double lnt = wifiInfoDTO.getLNT();
        double lat = wifiInfoDTO.getLAT();

        if (lat != 0 && !(lat >= 35 && lat <= 40)) {
            wifiInfoDTO.setLNT(lat); // 경도 (127.xxx)
            wifiInfoDTO.setLAT(lnt); // 위도 (37.xxx)
        }

        return wifiInfoDTO;
    }

    /**  api데이터 요청 후 데이터 db에 저장요청 */
    public int savePublicWifiData() throws IOException {
        List<JsonArray> jsonArrays = getApiJsonArrays();
        List<WifiInfoDTO> wifiInfoDTOList = mapJsonToDTO(jsonArrays);
        WifiInfoDAO wifiInfoDAO = WifiInfoDAOImpl.getInstance();

        return wifiInfoDAO.insertWifiInfo(wifiInfoDTOList);
    }
}