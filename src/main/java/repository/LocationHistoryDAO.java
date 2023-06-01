package repository;

import domain.WifiRequest;

public interface LocationHistoryDAO {
    void saveHistory(WifiRequest wifiRequest);

}
