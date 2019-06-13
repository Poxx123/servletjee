package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/showAllSession")
public class Sess03_All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        Enumeration<String> keys = session.getAttributeNames();
        response.getWriter().append("<table> ");
        for (String key : Collections.list(keys)) {
            response.getWriter().append("<tr><th>" + key + "</th>" +
                    "<th>" + session.getAttribute(key) + "</th>" +
                    "</tr>");
        }
        response.getWriter().append("</table>");

        session.setAttribute("keys", keys);
    }
}
