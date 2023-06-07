<%@ page import="domain.BookmarkGroupDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  List<BookmarkGroupDTO> list = (List<BookmarkGroupDTO>) request.getAttribute("list");
%>
<select name="bookmarkGroupSelect" id="bookmarkGroupSelect" value="hi">
  <option value="">북마크 그룹 이름 선택</option>
  <%
    if(!list.isEmpty()){
      for (BookmarkGroupDTO bookmarkGroupDTO : list) {
  %>
  <option value="<%=bookmarkGroupDTO.getId()%>"><%=bookmarkGroupDTO.getBookmarkName()%></option>
  <%
      }
  %>
  <%
    }
  %>
</select>
<input type="button" value="북마크 추가하기" onclick="addBookmark()">