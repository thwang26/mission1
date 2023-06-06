<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%

%>
<h1>북마크 그룹 추가</h1>
<jsp:include page="/view/component/navigation.jsp"/>
<form action="http://localhost:8080/bookmark-group-add-submit" method="post" id="bookmarkForm">
    <table id="table">
        <tr>
            <th style="width: 150px">북마크 이름</th>
            <td><input type="text" id="bookmarkName" name="bookmarkName"></td>
        </tr>
        <tr>
            <th style="width: 150px">순서</th>
            <td><input type="text" id="orderNum" name="orderNum"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="추가" onclick="addBookmark()">
            </td>
        </tr>
    </table>
</form>
<script src="${pageContext.request.contextPath}/js/bookmark.js"></script>
</body>
</html>