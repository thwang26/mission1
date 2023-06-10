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
    |   |   |   |-- BookmarkAddServlet.java
    |   |   |   |-- BookmarkGroupAddServlet.java
    |   |   |   |-- BookmarkGroupUpdateServlet.java
    |   |   |   |-- DeleteHistoryServlet.java
    |   |   |   `-- LoadWifiServlet.java
    |   |   |-- domain
    |   |   |   |-- BookmarkDTO.java
    |   |   |   |-- BookmarkGroupDTO.java
    |   |   |   |-- BookmarkGroupRequest.java
    |   |   |   |-- BookmarkRequest.java
    |   |   |   |-- LocationHistoryDTO.java
    |   |   |   |-- NearWifiDTO.java
    |   |   |   |-- WifiInfoDTO.java
    |   |   |   `-- WifiRequest.java
    |   |   |-- repository
    |   |   |   |-- BookmarkDAO.java
    |   |   |   |-- BookmarkDAOImpl.java
    |   |   |   |-- BookmarkGroupDAO.java
    |   |   |   |-- BookmarkGroupDAOImpl.java
    |   |   |   |-- LocationHistoryDAO.java
    |   |   |   |-- LocationHistoryDAOImpl.java
    |   |   |   |-- WifiInfoDAO.java
    |   |   |   `-- WifiInfoDAOImpl.java
    |   |   `-- service
    |   |       |-- BookmarkGroupService.java
    |   |       |-- BookmarkService.java
    |   |       |-- LocationHistoryService.java
    |   |       |-- OpenApiService.java
    |   |       `-- PublicWifiDataService.java
    |   |-- resources
    |   |   |-- mapper
    |   |   |   |-- bookmarkGroupMapper.xml
    |   |   |   |-- bookmarkMapper.xml
    |   |   |   |-- locationHistoryMapper.xml
    |   |   |   `-- wifiInfoMapper.xml
    |   |   |-- mybatis-config.xml
    |   |   `-- sql
    |   |       |-- bookmark.sql
    |   |       |-- bookmarkGroup.sql
    |   |       |-- locationHistory.sql
    |   |       `-- wifiInfo.sql
    |   `-- webapp
    |       |-- WEB-INF
    |       |   `-- web.xml
    |       |-- css
    |       |   `-- index.css
    |       |-- index.jsp
    |       |-- js
    |       |   |-- bookmark.js
    |       |   |-- bookmarkGroup.js
    |       |   |-- history.js
    |       |   `-- index.js
    |       `-- view
    |           |-- bookmark
    |           |   |-- bookmark-add-submit.jsp
    |           |   |-- bookmark-delete-submit.jsp
    |           |   |-- bookmark-delete.jsp
    |           |   `-- bookmark-list.jsp
    |           |-- bookmarkGroup
    |           |   |-- bookmark-group-add-submit.jsp
    |           |   |-- bookmark-group-add.jsp
    |           |   |-- bookmark-group-delete.jsp
    |           |   |-- bookmark-group-update-submit.jsp
    |           |   |-- bookmark-group-update.jsp
    |           |   `-- bookmark-group.jsp
    |           |-- component
    |           |   |-- bookmark-select.jsp
    |           |   |-- location-input.jsp
    |           |   `-- navigation.jsp
    |           |-- detail.jsp
    |           |-- history.jsp
    |           `-- load-wifi.jsp
    `-- test
        |-- java
        |   |-- BookmarkGroupServiceTest.java
        |   |-- BookmarkServiceTest.java
        |   |-- LocationHistoryServiceTest.java
        |   `-- PublicWifiDataServiceTest.java
        `-- resources
```