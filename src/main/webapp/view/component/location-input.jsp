<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String lat = request.getParameter("lat");
    String lnt = request.getParameter("lnt");
%>
LAT: <input type="text" id="lat" value="<%=lat%>" onfocusout="fillZero(this)">,
LNT: <input type="text" id="lnt" value="<%=lnt%>" onfocusout="fillZero(this)">
<input type="button" id="getMyLocationButton" value="내 위치 가져오기">
<input type="button" id="getNearWifiButton" value="근처 WIFI 정보 보기">
<br>
<br>