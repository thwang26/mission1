<%@ page import="domain.WifiRequest" %>
<%@ page import="service.GetNearWifiService" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.NearWifiDTO" %>
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
        GetNearWifiService getNearWifiService = new GetNearWifiService();
        lat = Double.parseDouble(request.getParameter("lat"));
        lnt = Double.parseDouble(request.getParameter("lnt"));

        wifiRequest.setLat(lat);
        wifiRequest.setLnt(lnt);

        list = getNearWifiService.getNearWifi(wifiRequest);

        if (!list.isEmpty()) {
            getNearWifiService.saveHistory(wifiRequest);
        }
    }
%>
<h1>와이파이 정보 구하기</h1>
<br>
<a href="http://localhost:8080">홈</a> |
<a href="http://localhost:8080/">위치 히스토리 목록</a> |
<a href="load-wifi">Open API 와이파이 정보 가져오기</a>
<br>
<br>
<form action="http://localhost:8080/?lat=" method="get">
    LAT: <input type="text" id="lat" value="<%=lat%>" onfocusout="fillZero(this)">,
    LNT: <input type="text" id="lnt" value="<%=lnt%>" onfocusout="fillZero(this)">
    <input type="button" id="getMyLocationButton" value="내 위치 가져오기">
    <input type="button" id="getNearWifiButton" value="근처 WIFI 정보 보기">
</form>
<br>
<table id="wifiInfo">
    <tr>
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    <%
        if(list != null){
            for (NearWifiDTO nearWifiDTO : list) {
    %>
    <tr>
        <td><%=nearWifiDTO.getDISTANCE()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_MGR_NO()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_WRDOFC()%></td>
        <td><%=nearWifiDTO.getX_SWIFI_MAIN_NM()%></td>
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
        <td><%=nearWifiDTO.getLAT()%></td>
        <td><%=nearWifiDTO.getLNT()%></td>
        <td><%=nearWifiDTO.getWORK_DTTM()%></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="17" height="50" style="font-weight: bold">위치 정보를 입력한 후에 조회해 주세요.</td>
    </tr>
    <%
        }
    %>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</table>
</body>
</html>