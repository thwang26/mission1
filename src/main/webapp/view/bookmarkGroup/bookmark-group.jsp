<%@ page import="service.BookmarkGroupService" %>
<%@ page import="domain.BookmarkGroupDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
    List<BookmarkGroupDTO> list = bookmarkGroupService.loadBookmarkGroupList();
%>
<h1>북마크 그룹</h1>
<jsp:include page="/view/component/navigation.jsp"/>
<input type="button" value="북마크 그룹 이름 추가" onclick="toAddBookmarkGroupPage()">
<table id="table">
    <tr>
        <th style="width: 50px">ID</th>
        <th style="width: 200px">북마크 이름</th>
        <th style="width: 70px">순서</th>
        <th style="width: 200px">등록일자</th>
        <th style="width: 200px">수정일자</th>
        <th style="width: 100px">비고</th>
    </tr>
    <%
        if(!list.isEmpty()) {
            for(BookmarkGroupDTO bookmarkGroupDTO : list) {
    %>
    <tr>
        <td><%=bookmarkGroupDTO.getId()%></td>
        <td><%=bookmarkGroupDTO.getBookmarkName()%></td>
        <td><%=bookmarkGroupDTO.getOrderNum()%></td>
        <td><%=bookmarkGroupDTO.getRegisterDate()%></td>
        <td>
            <%= bookmarkGroupDTO.getUpdateDate() == null
                    ? "-" : bookmarkGroupDTO.getUpdateDate() %>
        </td>
        <td>
            <input type="button" value="수정" onclick="toUpdateBookmarkGroupPage(<%=bookmarkGroupDTO.getId()%>)">
            <input type="button" value="삭제" onclick="deleteBookmarkGroup(<%=bookmarkGroupDTO.getId()%>)">
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="6" height="50" style="font-weight: bold; text-align: center">정보가 존재하지 않습니다.</td>
    </tr>
    <%
        }
    %>
</table>
<script src="${pageContext.request.contextPath}/js/bookmarkGroup.js"></script>
</body>
</html>