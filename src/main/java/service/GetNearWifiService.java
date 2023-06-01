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

    public List<NearWifiDTO> getNearWifi(WifiRequest wifiRequest) {
        WifiInfoDAO wifiInfoDAO = WifiInfoDAOImpl.getInstance();
        return wifiInfoDAO.selectNearWifi(wifiRequest);
    }
}
