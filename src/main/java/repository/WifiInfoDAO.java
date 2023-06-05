package repository;

import domain.NearWifiDTO;
import domain.WifiInfoDTO;
import domain.WifiRequest;

import java.util.List;

public interface WifiInfoDAO {
    int insertWifiInfo(List<WifiInfoDTO> wifiInfoDTOList);
    void delete();
    List<NearWifiDTO> loadNearWifi(WifiRequest wifiRequest);
    WifiInfoDTO loadDetail(String mgrNo);
}
