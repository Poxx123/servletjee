package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post5")
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String temp = request.getParameter("degrees");
        double tempD = 0;
        if (temp == null || temp.isEmpty()) {
            response.getWriter().append("Bledne dane");
        } else {
            tempD = Double.parseDouble(temp);
        }

        if (request.getParameter("convertionType").equals("FahrToCelc")) {
            double cels = (5 / 9.0) * (tempD - 32.0);
            response.getWriter().append(tempD + "F = " + cels + "C");
        } else {
            double fahr = 32.0 + ((9 / 5.0) * tempD);
            response.getWriter().append(tempD + "C = " + fahr + "F");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
