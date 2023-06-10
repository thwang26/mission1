<%@ page import="service.BookmarkService" %>
<%@ page import="domain.BookmarkDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    BookmarkService bookmarkService = new BookmarkService();
    List<BookmarkDTO> list = bookmarkService.loadBookmarkList();
%>
<h1>북마크 리스트</h1>
<jsp:include page="/view/component/navigation.jsp"/>
<table id="table">
    <tr>
        <th style="width: 100px">ID</th>
        <th style="width: 200px">북마크 이름</th>
        <th style="width: 300px">와이파이명</th>
        <th style="width: 300px">등록일자</th>
        <th style="width: 100px">비고</th>
    </tr>
    <%
        if (!list.isEmpty()) {
            for(BookmarkDTO bookmarkDTO : list) {
    %>
    <tr>
        <td>
            <%=bookmarkDTO.getId()%>
        </td>
        <td>
            <%=bookmarkDTO.getBookmarkName()%>
        </td>
        <td>
            <%=bookmarkDTO.getWifiName()%>
        </td>
        <td>
            <%=bookmarkDTO.getRegisterDate()%>
        </td>
        <td>
            <input type="button" value="삭제" onclick="toDeleteBookmarkPage(<%=bookmarkDTO.getId()%>)">
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="5" height="50" style="font-weight: bold; text-align: center">정보가 존재하지 않습니다.</td>
    </tr>
    <%
        }
    %>
</table>
<script src="${pageContext.request.contextPath}/js/bookmark.js"></script>
</body>
</html>