package service;

import domain.NearWifiDTO;
import domain.WifiRequest;
import repository.LocationHistoryDAO;
import repository.LocationHistoryDAOImpl;
import repository.WifiInfoDAO;
import repository.WifiInfoDAOImpl;

import java.util.List;

public class GetNearWifiService {
    public void saveHistory(WifiRequest wifiRequest) {
        LocationHistoryDAO LocationHistoryDAO = LocationHistoryDAOImpl.getInstance();
        LocationHistoryDAO.saveHistory(wifiRequest);
    }

    /** 가까운 반경 20개의 wifi 지역 가져오기 */
    public List<NearWifiDTO> getNearWifi(WifiRequest wifiRequest) {
        WifiInfoDAO wifiInfoDAO = WifiInfoDAOImpl.getInstance();
        return wifiInfoDAO.selectNearWifi(wifiRequest);
    }
}
