### 프로젝트 구조
```text
-- src
    |-- main
    |   |-- java
    |   |   |-- com
    |   |   |   `-- example
    |   |   |       `-- mission1
    |   |   |           |-- CommandProcess.java
    |   |   |           `-- HelloServlet.java
    |   |   |-- controller
    |   |   |   |-- BookmarkGroupSubmitServlet.java
    |   |   |   |-- DeleteHistoryServlet.java
    |   |   |   `-- LoadWifiServlet.java
    |   |   |-- domain
    |   |   |   |-- BookmarkDTO.java
    |   |   |   |-- BookmarkRequest.java
    |   |   |   |-- LocationHistoryDTO.java
    |   |   |   |-- NearWifiDTO.java
    |   |   |   |-- WifiInfoDTO.java
    |   |   |   `-- WifiRequest.java
    |   |   |-- repository
    |   |   |   |-- BookmarkDAO.java
    |   |   |   |-- BookmarkDAOImpl.java
    |   |   |   |-- LocationHistoryDAO.java
    |   |   |   |-- LocationHistoryDAOImpl.java
    |   |   |   |-- WifiInfoDAO.java
    |   |   |   `-- WifiInfoDAOImpl.java
    |   |   `-- service
    |   |       |-- BookmarkService.java
    |   |       |-- LocationHistoryService.java
    |   |       |-- OpenApiService.java
    |   |       `-- PublicWifiDataService.java
    |   |-- resources
    |   |   |-- bookmark.sql
    |   |   |-- bookmarkMapper.xml
    |   |   |-- locationHistory.sql
    |   |   |-- locationHistoryMapper.xml
    |   |   |-- mybatis-config.xml
    |   |   |-- wifiInfo.sql
    |   |   `-- wifiInfoMapper.xml
    |   `-- webapp
    |       |-- WEB-INF
    |       |   `-- web.xml
    |       |-- css
    |       |   `-- index.css
    |       |-- index.jsp
    |       |-- js
    |       |   |-- bookmark.js
    |       |   |-- history.js
    |       |   `-- index.js
    |       `-- view
    |           |-- bookmark-group-add-submit.jsp
    |           |-- bookmark-group-add.jsp
    |           |-- bookmark-group-edit.jsp
    |           |-- bookmark-group.jsp
    |           |-- bookmark-list.jsp
    |           |-- component
    |           |   |-- bookmark-select.jsp
    |           |   |-- location-input.jsp
    |           |   `-- navigation.jsp
    |           |-- detail.jsp
    |           |-- history.jsp
    |           `-- load-wifi.jsp
    `-- test
        |-- java
        |   |-- BookmarkServiceTest.java
        |   |-- LocationHistoryTest.java
        |   `-- PublicWifiDataServiceTest.java
        `-- resources
```
