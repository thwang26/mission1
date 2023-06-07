<%@ page import="service.BookmarkGroupService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>와이파이 정보 구하기</title>
</head>
<body>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
  bookmarkGroupService.deleteBookmarkGroup(id);
%>
</body>
<script>
  window.onload = function() {
    alert("북마크 그룹을 삭제하였습니다.");
    location.href = "bookmark-group.jsp";
  }
</script>
</html>