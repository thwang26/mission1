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
import java.util.concurrent.atomic.AtomicInteger;

public class PublicWifiDataService {
    public JsonArray getApi(int startIdx, int endIdx) throws IOException {
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
        JsonObject TbPublicWifiInfo = (JsonObject)jsonObject.get("TbPublicWifiInfo");
        rd.close();
        conn.disconnect();

        if (TbPublicWifiInfo == null) {
            return null;
        } else {
            return (JsonArray)TbPublicWifiInfo.get("row");
        }
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

    public List<JsonArray> getApiJsonArrays() {
        List<JsonArray> jsonArrays = new ArrayList<>();
        int startIdx = 1;
        int endIdx = 1000;
        final int range = 1000;

        List<Thread> threads = new ArrayList<>();

        do {
            int finalStartIdx = startIdx;
            int finalEndIdx = endIdx;

            Thread thread = new Thread(() -> {
                try {
                    JsonArray jsonArray = getApi(finalStartIdx, finalEndIdx);
                    synchronized (jsonArrays) {
                        jsonArrays.add(jsonArray);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            threads.add(thread);
            thread.start();

            startIdx += range;
            endIdx += range;

            // 데이터를 모두 가져왔을 때 종료
        } while (startIdx < 24000);

        // 모든 스레드가 작업을 완료할 때까지 대기
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return jsonArrays;
    } // 멀티쓰레드 사용

    public List<WifiInfoDTO> mapJsonToDTO(List<JsonArray> jsonArrays) {
        List<WifiInfoDTO> wifiInfoDTOList = new ArrayList<>();

        for (JsonArray jsonArray: jsonArrays) {
            for (JsonElement jsonElement: jsonArray) {
                if (!jsonElement.isJsonNull()) {
                    WifiInfoDTO wifiInfoDTO = new Gson().fromJson(jsonElement, WifiInfoDTO.class);
                    wifiInfoDTOList.add(wifiInfoDTO);
                }
            }
        }

        return wifiInfoDTOList;
    }

    public int savePublicWifiData() throws IOException {
        List<JsonArray> jsonArrays = getApiJsonArrays();
        List<WifiInfoDTO> wifiInfoDTOList = mapJsonToDTO(jsonArrays);
        WifiInfoDAO wifiInfoDAO = WifiInfoDAOImpl.getInstance();

        return wifiInfoDAO.insertWifiInfo(wifiInfoDTOList);
    }
}