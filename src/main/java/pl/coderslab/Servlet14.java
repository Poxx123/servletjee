package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;

@WebServlet("/servlet14")
public class Servlet14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("IP address: " + request.getRemoteAddr() + "<br>");
        response.getWriter().append("Browser: " + request.getHeader("User-Agent") + "<br>");

        String user = request.getHeader("User-Agent");
        String browser = "";
        if (user.contains("msie") || user.contains("Msie")) {
            browser = "Internet Explorer";
        } else if (user.contains("chrome") || user.contains("Chrome")) {
            browser = "Chrome";
        } else if (user.contains("safari") || user.contains("Safari")) {
            browser = "Safari";
        } else if (user.contains("opr") || user.contains("Opr")) {
            browser = "Opera";
        } else if (user.contains("firefox") || user.contains("Firefox")) {
            browser = "Firefox";
        } else {
            browser = "UnKnown, More-Info: " + user;
        }

        response.getWriter().append("User-Agent: " + user + "<br>");
        response.getWriter().append("Browser: " + browser + "<br>");
        response.getWriter().append("Time: " + new Date().toString() + "<br>");

        response.getWriter().append("Time: " + LocalTime.now().toString());
    }
}
