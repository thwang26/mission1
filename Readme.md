# 내 위치 기반 공공 와이파이 서비스
### 과제 시나리오 
```text
내 위치 기반 공공 와이파이 정보를 제공하는 웹서비스 개발
```
### 구현 내용
```text
1. Open API 와이파이 정보 가져오기
    
    데이터를 저장할 때 걸리는 시간을 단축하는 것이 해당 기능의 핵심이라고 생각하였습니다.
    초기에는 단순히 천 개의 데이터를 24 번 요청하여 저장하는 방식을 사용하였습니다. (4초의 저장시간 소요)
    해당 기능에서 가장 시간이 오래 걸리는 부분이 자바단에서 api를 요청하는 데 걸리는 시간이었습니다.
    요청하는 데 걸리는 시간을 최대한 줄이고자 멀티스레드 방식을 사용하여 api를 병렬로 요청하여 시간을 단축하였고 
    가져온 데이터를 db에 저장할 때 배치처리를 사용하여 최종 저장시간을 2초대 까지 단축하였습니다.
    
2. 내 위치 가져오기 후 근처 wifi 정보 보기

    근처 Wi-Fi를 가져오는 로직을 db에서 수행할 때 Open API에서 가져오는 데이터의 위도, 경도 값이 
    잘못되어 실제로 가까운 20개의 데이터를 가져오는 데 잘못된 정보를 가져오는 이슈가 있었습니다
    해당 이슈는 위도와 경도값을 확인하여 보정 해 주는 로직을 수행하여 해결하였습니다. 

3. 위치 히스토리 목록

4. Wi-Fi 상세 정보 보기
    
5. 북마크 그룹 목록/추가/수정/삭제 (CRUD)

6. Wi-Fi 북마크 추가 및 삭제기능
```

### erd테이블
![img](https://ifh.cc/g/2Omk7k.jpg)
```text
1. wifiInfo : Open API로 가져온 데이터를 저장하는 테이블
2. locationHistory : 내 위치 가져오기 검색 시 히스토리로 저장하는 테이블
3. bookmarkGroup : 북마크 그룹 (CRUD) 테이블
4. bookmark : 북마크에 저장된 Wi-Fi정보를 저장하는 테이블, 그룹 ID와 Wi-Fi 관리번호를 FK로 지정하여 저장
```

### 프로젝트 구조
```text
1. 자바

MVC 모델을 준수하여 크게 Controller, Repository, Domain, Service 총 4개의 구조로 나누었습니다.
Mybatis 라이브러리를 사용하여 자바에서 db에 접근하였고, 소스코드의 가독성을 높이면서 관리하기 용이하기 위해
채택하여 사용하였습니다.
쿼리문 파일과 Mybatis 설정파일은 resources 디렉토리에 모아두어 따로 관리하였습니다.

2. jsp 페이지

    1. jsp -> java 로직 처리 
    jsp에서 기능 로직을 수행 할 때에는 어떻게 로직을 수행해야 하느냐에 따라 
    servlet클래스로 접근하여 처리하는 방식과 직접 jsp페이지로 이동하여 처리하는 방식을 선택하였습니다.

    2. 페이지 디렉토리 구조 
    페이지에서 반복되거나 jsp 페이지에 가독성을 떨어뜨릴 수 있는 네비게이션 바, select바 등은 
    component 디렉토리를 만들어 따로 관리하였습니다.
    css, javascript 또한 따로 파일과 디렉토리를 만들어 관리하였습니다.
    북마크 그룹과 북마크와 같이 기능을 구현하기 위해 많은 페이지가 필요한 경우 디렉토리를 따로 만들어
    구분하였습니다.
    
3. 테스트 코드 작성

jsp 페이지를 만들어서 직접 버튼을 눌러 구현되는걸 확인 하는 것 대신
각 기능에 대한 테스트 코드를 작성하였습니다.

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
    |   |   |   |-- UrlParameters.java
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
