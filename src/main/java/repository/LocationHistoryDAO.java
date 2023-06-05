package repository;

import domain.LocationHistoryDTO;
import domain.WifiRequest;

import java.util.List;

public interface LocationHistoryDAO {
    void saveHistory(WifiRequest wifiRequest);
    List<LocationHistoryDTO> loadHistory();
    void deleteHistory(int id);
}
