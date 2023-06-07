<%@ page import="service.BookmarkGroupService" %>
<%@ page import="domain.BookmarkGroupDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    BookmarkGroupService bookmarkService = new BookmarkGroupService();
    BookmarkGroupDTO bookmarkGroupDTO = bookmarkService.loadBookmarkGroup(id);
%>
<h1>북마크 그룹 수정</h1>
<jsp:include page="/view/component/navigation.jsp"/>
<form action="http://localhost:8080/bookmark-group-update-submit" method="post" id="bookmarkUpdateForm">
    <input type="hidden" name="id" value="<%=id%>">
    <table id="table">
        <tr>
            <th style="width: 150px">북마크 이름</th>
            <td>
                <input type="text" name="bookmarkName" id="bookmarkName" value="<%=bookmarkGroupDTO.getBookmarkName()%>">
            </td>
        </tr>
        <tr>
            <th style="width: 150px">순서</th>
            <td>
                <input type="text" name="orderNum" id="orderNum" value="<%=bookmarkGroupDTO.getOrderNum()%>">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="수정" onclick="updateBookmarkGroup()">
                <input type="button" value="취소" onclick="cancel()">
            </td>
        </tr>
    </table>
</form>
<script src="${pageContext.request.contextPath}/js/bookmarkGroup.js"></script>
</body>
</html>