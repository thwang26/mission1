package controller;

import service.PublicWifiDataService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "load-wifi", value = "/load-wifi")
public class LoadWifiServlet extends HttpServlet{
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                HttpSession session = request.getSession();
                PublicWifiDataService publicWifiDataService = new PublicWifiDataService();
                int number = publicWifiDataService.savePublicWifiData();
                session.setAttribute("number", number);
                response.sendRedirect("/view/load-wifi.jsp");
        }
}