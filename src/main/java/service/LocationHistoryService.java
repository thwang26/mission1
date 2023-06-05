package service;

import domain.LocationHistoryDTO;
import domain.WifiRequest;
import repository.LocationHistoryDAO;
import repository.LocationHistoryDAOImpl;

import java.util.List;

public class LocationHistoryService {
    LocationHistoryDAO locationHistoryDAO = LocationHistoryDAOImpl.getInstance();

    /** 히스토리 저장 */
    public void saveHistory(WifiRequest wifiRequest) {
        locationHistoryDAO.saveHistory(wifiRequest);
    }

    /** 히스토리 불러오기 */
    public List<LocationHistoryDTO> loadHistory() {
        return locationHistoryDAO.loadHistory();
    }

    /** 히스토리 삭제 */
    public void deleteHistory(int id) {
        locationHistoryDAO.deleteHistory(id);
    }
}
