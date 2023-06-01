<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int number = (int) session.getAttribute("number");
    session.invalidate();
%>
<h1><%= number %>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
<a href = "http://localhost:8080">홈 으로 가기</a>
</body>
</html>
