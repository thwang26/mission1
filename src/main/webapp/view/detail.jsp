<%@ page import="service.PublicWifiDataService" %>
<%@ page import="domain.WifiInfoDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>와이파이 정보 구하기</title>
  <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
  String mgrNo = request.getParameter("mgrNo");
  double distance = Double.parseDouble(request.getParameter("distance"));
  PublicWifiDataService publicWifiDataService = new PublicWifiDataService();
  WifiInfoDTO wifiInfoDTO = publicWifiDataService.loadDetail(mgrNo);
%>
<h1>와이파이 정보 구하기</h1>
<jsp:include page="/view/component/navigation.jsp"/>
<jsp:include page="/view/component/bookmark-select.jsp"/>
<table id="table">
  <tr>
    <th>거리(Km)</th>
    <td><%=distance%></td>
  </tr>
  <tr>
    <th>관리번호</th>
    <td><%=wifiInfoDTO.getX_SWIFI_MGR_NO()%></td>
  </tr>
  <tr>
    <th>자치구</th>
    <td><%=wifiInfoDTO.getX_SWIFI_WRDOFC()%></td>
  </tr>
  <tr>
    <th>와이파이명</th>
    <td><%=wifiInfoDTO.getX_SWIFI_MAIN_NM()%></td>
  </tr>
  <tr>
    <th>도로명주소</th>
    <td><%=wifiInfoDTO.getX_SWIFI_ADRES1()%></td>
  </tr>
  <tr>
    <th>상세주소</th>
    <td><%=wifiInfoDTO.getX_SWIFI_ADRES2()%></td>
  </tr>
  <tr>
    <th>설치위치(층)</th>
    <td><%=wifiInfoDTO.getX_SWIFI_INSTL_FLOOR()%></td>
  </tr>
  <tr>
    <th>설치유형</th>
    <td><%=wifiInfoDTO.getX_SWIFI_INSTL_TY()%></td>
  </tr>
  <tr>
    <th>설치기관</th>
    <td><%=wifiInfoDTO.getX_SWIFI_INSTL_MBY()%></td>
  </tr>
  <tr>
    <th>서비스구분</th>
    <td><%=wifiInfoDTO.getX_SWIFI_SVC_SE()%></td>
  </tr>
  <tr>
    <th>망종류</th>
    <td><%=wifiInfoDTO.getX_SWIFI_CMCWR()%></td>
  </tr>
  <tr>
    <th>설치년도</th>
    <td><%=wifiInfoDTO.getX_SWIFI_CNSTC_YEAR()%></td>
  </tr>
  <tr>
    <th>실내외구분</th>
    <td><%=wifiInfoDTO.getX_SWIFI_INOUT_DOOR()%></td>
  </tr>
  <tr>
    <th>WIFI접속환경</th>
    <td><%=wifiInfoDTO.getX_SWIFI_REMARS3()%></td>
  </tr>
  <tr>
    <th>X좌표</th>
    <td><%=wifiInfoDTO.getLAT()%></td>
  </tr>
  <tr>
    <th>Y좌표</th>
    <td><%=wifiInfoDTO.getLNT()%></td>
  </tr>
  <tr>
    <th>작업일자</th>
    <td><%=wifiInfoDTO.getWORK_DTTM()%></td>
  </tr>
</table>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>