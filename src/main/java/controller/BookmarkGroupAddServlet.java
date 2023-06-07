package controller;

import domain.BookmarkGroupRequest;
import service.BookmarkGroupService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookmark-group-add-submit", value = "/bookmark-group-add-submit")
public class BookmarkGroupAddServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
        BookmarkGroupRequest bookmarkGroupRequest = new BookmarkGroupRequest();
        request.setCharacterEncoding("UTF-8");
        String bookmarkName = request.getParameter("bookmarkName");
        int orderNum = Integer.parseInt(request.getParameter("orderNum"));

        bookmarkGroupRequest.setBookmarkName(bookmarkName);
        bookmarkGroupRequest.setOrderNum(orderNum);
        int num = bookmarkGroupService.saveBookmarkGroup(bookmarkGroupRequest);
        response.sendRedirect("/view/bookmarkGroup/bookmark-group-add-submit.jsp");
    }
}