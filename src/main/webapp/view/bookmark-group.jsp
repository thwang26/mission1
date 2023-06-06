<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%

%>
<h1>북마크 그룹</h1>
<jsp:include page="/view/component/navigation.jsp"/>
<input type="button" value="북마크 그룹 이름 추가" onclick="toBookmarkAdd()">
<table id="table">
    <tr>
        <th style="width: 50px">ID</th>
        <th style="width: 200px">북마크 이름</th>
        <th style="width: 70px">순서</th>
        <th style="width: 200px">등록일자</th>
        <th style="width: 200px">수정일자</th>
        <th style="width: 100px">비고</th>
    </tr>
<%--    <%=if() {%>--%>
<%--    <%=    for() {%>--%>
<%--    <tr>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--        <td>--%>
<%--            <input type="button" id="updateBookmarkButton" value="수정">--%>
<%--            <input type="button" id="deleteBookmarkButton" value="삭제">--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <%=    }%>--%>
<%--    <%=} else {%>--%>
<%--    <tr>정보가 존재하지 않습니다.</tr>--%>
<%--    <%=}%>--%>
</table>
<script src="${pageContext.request.contextPath}/js/bookmark.js"></script>
</body>
</html>