package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean found = false;
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if ("User".equals(c.getName())) {
                    response.getWriter().append("User: " + c.getValue() + " valid: " + c.getMaxAge());
                    found = true;
                    response.getWriter().append("Ciacho skasowane.");
                }
            }
        }
        if (!found) {
            response.getWriter().append("Brak takiego ciacha.");
        }
    }
}
