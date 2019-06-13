package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/get5")
public class Get5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            response.getWriter().append(entry.getKey() + ": \n");
            for (String s : entry.getValue()) {
                response.getWriter().append("- " + s + "\n");
            }
        }
    }
}

