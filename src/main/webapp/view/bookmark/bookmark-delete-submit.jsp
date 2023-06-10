<%@ page import="service.BookmarkGroupService" %>
<%@ page import="service.BookmarkService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    BookmarkService bookmarkService = new BookmarkService();
    bookmarkService.deleteBookmark(id);
%>
</body>
<script>
    window.onload = function() {
        alert("북마크 정보를 삭제하였습니다.");
        location.href = "bookmark-list.jsp";
    }
</script>
</html>