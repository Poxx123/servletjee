package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc12")
public class Mvc12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String start = request.getParameter("start");
        String end = request.getParameter("end");

        if (start == null || end == null || start.isEmpty() || end.isEmpty()) {
            response.getWriter().append("Wrong values.");
        } else {
            try {
                int startI = Integer.parseInt(start);
                int endI = Integer.parseInt(end);
                request.setAttribute("start", startI + 10);
                request.setAttribute("end", endI + 10);
                request.getRequestDispatcher("/jsp12.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.getWriter().append("Wrong format.");
            }
        }
    }
}
