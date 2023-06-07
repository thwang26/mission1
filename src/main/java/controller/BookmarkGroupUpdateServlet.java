package controller;

import domain.BookmarkGroupRequest;
import service.BookmarkGroupService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookmark-group-update-submit", value = "/bookmark-group-update-submit")
public class BookmarkGroupUpdateServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
        BookmarkGroupRequest bookmarkGroupRequest = new BookmarkGroupRequest();
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String bookmarkName = request.getParameter("bookmarkName");
        int orderNum = Integer.parseInt(request.getParameter("orderNum"));

        bookmarkGroupRequest.setId(id);
        bookmarkGroupRequest.setBookmarkName(bookmarkName);
        bookmarkGroupRequest.setOrderNum(orderNum);
        int num = bookmarkGroupService.updateBookmarkGroup(bookmarkGroupRequest);
        response.sendRedirect("/view/bookmarkGroup/bookmark-group-update-submit.jsp");
    }
}