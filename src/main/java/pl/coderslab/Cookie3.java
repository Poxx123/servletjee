package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie3")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String time = request.getParameter("time");

        if(key == null || value == null || time == null || key.isEmpty() || value.isEmpty() || time.isEmpty()){
            response.getWriter().append("Bledne dane.");
        } else {
            Cookie c = new Cookie(key, value);
            c.setMaxAge(Integer.parseInt(time) * 3600);
            c.setPath("/");
            response.addCookie(c);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cookie3.html").forward(request, response);
    }
}
