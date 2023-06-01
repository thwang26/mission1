package repository;

import domain.NearWifiDTO;
import domain.WifiInfoDTO;
import domain.WifiRequest;

import java.util.List;

public interface WifiInfoDAO {
    public int insertWifiInfo(List<WifiInfoDTO> wifiInfoDTOList);
    public void delete();
    public List<NearWifiDTO> selectNearWifi(WifiRequest wifiRequest);
}
