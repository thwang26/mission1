import com.google.gson.JsonArray;
import domain.WifiInfoDTO;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.WifiInfoDAO;
import repository.WifiInfoDAOImpl;
import service.PublicWifiDataService;

import java.io.IOException;

public class PublicWifiDataServiceTest {
    PublicWifiDataService publicWifiDataService = new PublicWifiDataService();
    WifiInfoDAOImpl wifiInfoDAOImpl = WifiInfoDAOImpl.getInstance();
    WifiInfoDTO wifiInfoDTO = new WifiInfoDTO();

    @DisplayName("api 호출 테스트")
    @Test
    public void checkApi() throws IOException {
        // given

        // when
        JsonArray jsonArray = publicWifiDataService.getApi(1, 1);
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

}
