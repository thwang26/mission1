<%@ page import="domain.WifiRequest" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.NearWifiDTO" %>
<%@ page import="service.LocationHistoryService" %>
<%@ page import="service.PublicWifiDataService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    double lat = 0.0;
    double lnt = 0.0;
    List<NearWifiDTO> list = null;

    if (request.getParameter("lat") != null && request.getParameter("lnt") != null) {
        WifiRequest wifiRequest = new WifiRequest();
        PublicWifiDataService publicWifiDataService = new PublicWifiDataService();
        LocationHistoryService locationHistoryService = new LocationHistoryService();
        lat = Double.parseDouble(request.getParameter("lat"));
        lnt = Double.parseDouble(request.getParameter("lnt"));

        wifiRequest.setLat(lat);
        wifiRequest.setLnt(lnt);

        list = publicWifiDataService.loadNearWifi(wifiRequest);

        if (!list.isEmpty()) {
            locationHistoryService.saveHistory(wifiRequest);
        }
    }
%>
<h1>와이파이 정보 구하기</h1>
<jsp:include page="/view/component/navigation.jsp"/>
<jsp:include page="/view/component/location-input.jsp">
    <jsp:param name="lat" value="<%=lat%>"/>
    <jsp:param name="lnt" value="<%=lnt%>"/>
</jsp:include>
<table id="table">
    <tr>
        <th style="width: 70px">거리(Km)</th>
        <th style="width: 80px">관리번호</th>
        <th style="width: 100px">자치구</th>
        <th style="width: 200px">와이파이명</th>
        <th style="width: 200px">도로명주소</th>
        <th style="width: 200px">상세주소</th>
        <th style="width: 80px">설치위치(층)</th>
        <th style="width: 150px">설치유형</th>
        <th style="width: 100px">설치기관</th>
        <th style="width: 100px">서비스구분</th>
        <th style="width: 100px">망종류</th>
        <th style="width: 80px">설치년도</th>
        <th style="width: 80px">실내외구분</th>
        <th style="width: 100px">WIFI접속환경</th>
        <th style="width: 100px">X좌표</th>
        <th style="width: 100px">Y좌표</th>
        <th style="width: 100px">작업일자</th>
    </tr>
    <%
        if(list != null){
            for (NearWifiDTO nearWifiDTO : list) {
    %>
    <tr>
        <td><%=nearWifiDTO.getDISTANCE()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_MGR_NO()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_WRDOFC()%></td>
        <td><a href="http://localhost:8080/view/detail.jsp?mgrNo=
<%=nearWifiDTO.getX_SWIFI_MGR_NO()%>&distance=
<%=nearWifiDTO.getDISTANCE()%>">
            <%=nearWifiDTO.getX_SWIFI_MAIN_NM()%></a></td>
        <td><%=nearWifiDTO.getX_SWIFI_ADRES1()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_ADRES2()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_INSTL_FLOOR()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_INSTL_TY()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_INSTL_MBY()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_SVC_SE()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_CMCWR()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_CNSTC_YEAR()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_INOUT_DOOR()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_REMARS3()%></td>
        <td><%=nearWifiDTO.getLNT()%></td>
        <td><%=nearWifiDTO.getLAT()%></td>
        <td><%=nearWifiDTO.getWORK_DTTM()%></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="17" height="50" style="font-weight: bold; text-align: center">위치 정보를 입력한 후에 조회해 주세요.</td>
    </tr>
    <%
        }
    %>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</table>
</body>
</html>