import com.google.gson.JsonArray;
import domain.LocationHistoryDTO;
import domain.NearWifiDTO;
import domain.WifiInfoDTO;
import domain.WifiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.WifiInfoDAO;
import repository.WifiInfoDAOImpl;
import service.LocationHistoryService;
import service.OpenApiService;
import service.PublicWifiDataService;

import javax.xml.stream.Location;
import java.io.IOException;
import java.util.List;

public class PublicWifiDataServiceTest {
    PublicWifiDataService publicWifiDataService = new PublicWifiDataService();
    WifiInfoDAOImpl wifiInfoDAOImpl = WifiInfoDAOImpl.getInstance();
    WifiInfoDTO wifiInfoDTO = new WifiInfoDTO();
    OpenApiService openApiService = new OpenApiService();

    @DisplayName("api 호출 테스트")
    @Test
    public void checkApi() throws IOException {
        // given
        OpenApiService openApiService = new OpenApiService();

        // when
        JsonArray jsonArray = (JsonArray) openApiService.getApi(1, 1).get("row");
        System.out.println(jsonArray.toString());
        // then
        Assertions.assertFalse(jsonArray.isJsonNull());

    }

    @DisplayName("api 데이터 save 테스트")
    @Test
    public void checkSaveWifiData() throws IOException {
        // given


        // when
        int number = publicWifiDataService.savePublicWifiData();

        // then
        Assertions.assertEquals(23304, number);
    }

    @DisplayName("20개 가져오기 테스트")
    @Test
    public void getNearWifi() {
        // given
        WifiRequest wifiRequest = new WifiRequest();
        wifiRequest.setLnt(127);
        wifiRequest.setLat(37);

        // when
        List<NearWifiDTO> list = wifiInfoDAOImpl.loadNearWifi(wifiRequest);

        // then
        Assertions.assertEquals(20, list.size());

    }

    @DisplayName("세부정보 가져오기 테스트")
    @Test
    public void loadDetail() {
        // given
        String mgrNo = "서울4차-6693-1";

        // when
        WifiInfoDTO wifiInfoDTO = publicWifiDataService.loadDetail(mgrNo);

        // then
        Assertions.assertNotNull(wifiInfoDTO);
    }

    @DisplayName("멀티스레드+배치처리 성능 테스트")
    @Test
    public void speedTest() throws IOException {
        int runCnt = 10;
        long totalTime = 0;
        for (int i = 0; i < runCnt; i++) {
            long start = System.currentTimeMillis();
            List<JsonArray> jsonArrays = openApiService.getApiJsonArrays();
            List<WifiInfoDTO> wifiInfoDTOList = openApiService.mapJsonToDTO(jsonArrays);
            wifiInfoDAOImpl.insertWifiInfo(wifiInfoDTOList);
            long end = System.currentTimeMillis();
            totalTime += end - start;
        }

        System.out.println("평균 소요시간 = " + totalTime/runCnt + "ms");
    }
}
