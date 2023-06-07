import domain.LocationHistoryDTO;
import domain.WifiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.LocationHistoryDAOImpl;
import service.LocationHistoryService;

import java.util.List;

public class LocationHistoryServiceTest {
    LocationHistoryDAOImpl locationHistoryDAO = LocationHistoryDAOImpl.getInstance();
    LocationHistoryService locationHistoryService = new LocationHistoryService();

    WifiRequest wifiRequest = new WifiRequest();

    @DisplayName("history 등록 테스트")
    @Test
    public void saveHistory() {
        // given
        wifiRequest.setLnt(1);
        wifiRequest.setLat(2);

        // when
        locationHistoryDAO.saveHistory(wifiRequest);

        // then
    }

    @DisplayName("history 조회")
    @Test
    public void loadHistory() {
        // given

        // when
        List<LocationHistoryDTO> list = locationHistoryService.loadHistory();

        // then
        Assertions.assertNotNull(list);
    }

    @DisplayName("history 삭제")
    @Test
    public void deleteHistory() {
        // given
        int id = 238;

        // when
        locationHistoryService.deleteHistory(id);

        // then
    }
}
