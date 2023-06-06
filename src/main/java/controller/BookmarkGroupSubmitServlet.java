package controller;

import domain.BookmarkRequest;
import service.BookmarkService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookmark-group-add-submit", value = "/bookmark-group-add-submit")
public class BookmarkGroupSubmitServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BookmarkService bookmarkService = new BookmarkService();
        BookmarkRequest bookmarkRequest = new BookmarkRequest();
        request.setCharacterEncoding("UTF-8");
        String bookmarkName = request.getParameter("bookmarkName");
        int orderNum = Integer.parseInt(request.getParameter("orderNum"));

        bookmarkRequest.setBookmarkName(bookmarkName);
        bookmarkRequest.setOrderNum(orderNum);
        int num = bookmarkService.saveBookmarkGroup(bookmarkRequest);
        response.sendRedirect("/view/bookmark-group-add-submit.jsp");
    }
}