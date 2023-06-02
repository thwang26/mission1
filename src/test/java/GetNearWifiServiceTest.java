import domain.NearWifiDTO;
import domain.WifiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.LocationHistoryDAOImpl;
import repository.WifiInfoDAO;
import repository.WifiInfoDAOImpl;

import java.util.List;

public class GetNearWifiServiceTest {
    WifiInfoDAO wifiInfoDAO = WifiInfoDAOImpl.getInstance();
    LocationHistoryDAOImpl locationHistoryDAO = LocationHistoryDAOImpl.getInstance();
    WifiRequest wifiRequest = new WifiRequest();
    @DisplayName("20개 가져오기 테스트")
    @Test
    public void getNearWifi() {
        // given
        wifiRequest.setLnt(127);
        wifiRequest.setLat(37);

        // when
        List<NearWifiDTO> list = wifiInfoDAO.selectNearWifi(wifiRequest);

        // then
        Assertions.assertEquals(20, list.size());

    }

    @DisplayName("history 등록 테스트")
    @Test
    public void saveHistory() {
        // given
        wifiRequest.setLnt(1);
        wifiRequest.setLat(2);

        // when
        int cnt = locationHistoryDAO.saveHistoryTest(wifiRequest);

        // then
        Assertions.assertEquals(1, cnt);
    }
}
