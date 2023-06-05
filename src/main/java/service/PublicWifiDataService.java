package service;


import com.google.gson.*;
import domain.NearWifiDTO;
import domain.WifiInfoDTO;
import domain.WifiRequest;
import repository.WifiInfoDAO;
import repository.WifiInfoDAOImpl;

import java.io.IOException;
import java.util.List;

public class PublicWifiDataService {
    WifiInfoDAO wifiInfoDAO = WifiInfoDAOImpl.getInstance();

    /**  api데이터 요청 후 데이터 db에 저장요청 */
    public int savePublicWifiData() throws IOException {
        OpenApiService openApiService = new OpenApiService();
        List<JsonArray> jsonArrays = openApiService.getApiJsonArrays();
        List<WifiInfoDTO> wifiInfoDTOList = openApiService.mapJsonToDTO(jsonArrays);
        return wifiInfoDAO.insertWifiInfo(wifiInfoDTOList);
    }

    /** 가까운 반경 20개의 wifi 지역 가져오기 */
    public List<NearWifiDTO> loadNearWifi(WifiRequest wifiRequest) {
        return wifiInfoDAO.loadNearWifi(wifiRequest);
    }

    /** 와이파이 세부정보 구하기 */
    public WifiInfoDTO loadDetail(String mgrNo) {
        return wifiInfoDAO.loadDetail(mgrNo);
    }
}