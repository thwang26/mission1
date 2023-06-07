package controller;

import domain.BookmarkRequest;
import service.BookmarkService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookmark-add-submit", value = "/bookmark-add-submit")
public class BookmarkAddServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BookmarkRequest bookmarkRequest = new BookmarkRequest();
        BookmarkService bookmarkService = new BookmarkService();
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String mgrNo = request.getParameter("mgrNo");

        bookmarkRequest.setId(id);
        bookmarkRequest.setMgrNo(mgrNo);
        bookmarkService.saveBookmark(bookmarkRequest);
        response.sendRedirect("/view/bookmark/bookmark-add-submit.jsp");
    }
}