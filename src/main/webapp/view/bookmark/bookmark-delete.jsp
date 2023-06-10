<%@ page import="domain.BookmarkDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="service.BookmarkService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    BookmarkService bookmarkService = new BookmarkService();
    BookmarkDTO bookmarkDTO = bookmarkService.loadBookmark(id);
%>
<h1>북마크 삭제</h1>
<jsp:include page="/view/component/navigation.jsp"/>
<p>북마크를 삭제하시겠습니까?</p>
<table id="table">
    <tr>
        <th style="width: 200px">북마크 이름</th>
        <td><%=bookmarkDTO.getBookmarkName()%></td>
    </tr>
    <tr>
        <th style="width: 300px">와이파이명</th>
        <td><%=bookmarkDTO.getWifiName()%></td>
    </tr>
    <tr>
        <th style="width: 300px">등록일자</th>
        <td><%=bookmarkDTO.getRegisterDate()%></td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center">
            <input type="button" value="삭제" onclick="deleteBookmark(<%=id%>)"> |
            <input type="button" value="취소" onclick="cancel()">
        </td>
    </tr>
</table>
<script src="${pageContext.request.contextPath}/js/bookmark.js"></script>
<script src="${pageContext.request.contextPath}/js/bookmarkGroup.js"></script>
</body>
</html>