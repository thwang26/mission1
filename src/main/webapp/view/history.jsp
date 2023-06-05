<%@ page import="service.LocationHistoryService" %>
<%@ page import="domain.LocationHistoryDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    LocationHistoryService locationHistoryService = new LocationHistoryService();
    List<LocationHistoryDTO> list = locationHistoryService.loadHistory();
%>
<h1>위치 히스토리 목록</h1>
<jsp:include page="/view/navigation.jsp"/>
<br>
<table id="locationHistory">
    <tr>
        <th style="width: 100px">ID</th>
        <th style="width: 400px">X좌표</th>
        <th style="width: 400px">Y좌표</th>
        <th style="width: 500px">조회일자</th>
        <th style="width: 200px">비고</th>
    </tr>
    <%
        if(list != null){
            for (LocationHistoryDTO locationHistoryDTO : list) {
    %>
    <tr>
        <td><%=locationHistoryDTO.getId()%></td>
        <td><%=locationHistoryDTO.getLnt()%></td>
        <td><%=locationHistoryDTO.getLat()%></td>
        <td><%=locationHistoryDTO.getSearch_date()%></td>
        <td><input type="button" style="text-align: center" value="삭제" onclick="deleteHistory(<%=locationHistoryDTO.getId()%>)"></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5" height="50" style="font-weight: bold">히스토리가 없습니다.</td>
    </tr>
    <%
        }
    %>
</table>
<script src="${pageContext.request.contextPath}/js/history.js"></script>
</body>
</html>