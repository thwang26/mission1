package controller;

import service.LocationHistoryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete-history", value = "/delete-history")
public class DeleteHistoryServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LocationHistoryService locationHistoryService = new LocationHistoryService();
        int id = Integer.parseInt(request.getParameter("id"));
        locationHistoryService.deleteHistory(id);
        response.sendRedirect("/view/history.jsp");
    }
}