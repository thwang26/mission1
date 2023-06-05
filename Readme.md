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
|   |   |   |-- DeleteHistoryServlet.java
|   |   |   `-- LoadWifiServlet.java
|   |   |-- domain
|   |   |   |-- LocationHistoryDTO.java
|   |   |   |-- NearWifiDTO.java
|   |   |   |-- WifiInfoDTO.java
|   |   |   `-- WifiRequest.java
|   |   |-- repository
|   |   |   |-- LocationHistoryDAO.java
|   |   |   |-- LocationHistoryDAOImpl.java
|   |   |   |-- WifiInfoDAO.java
|   |   |   `-- WifiInfoDAOImpl.java
|   |   `-- service
|   |       |-- LocationHistoryService.java
|   |       |-- OpenApiService.java
|   |       `-- PublicWifiDataService.java
|   |-- resources
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
|       |   |-- history.js
|       |   `-- index.js
|       `-- view
|           |-- detail.jsp
|           |-- history.jsp
|           |-- load-wifi.jsp
|           `-- navigation.jsp
`-- test
|-- java
|   |-- LocationHistoryTest.java
|   `-- PublicWifiDataServiceTest.java
`-- resources
```
