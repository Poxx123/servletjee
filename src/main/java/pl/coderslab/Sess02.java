package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sess02")
public class Sess02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Integer> grades;
        if (session.getAttribute("grades") == null) {
            grades = new ArrayList<>();
        } else {
            grades = (List<Integer>) session.getAttribute("grades");
        }
        try {
            grades.add(Integer.parseInt(request.getParameter("grade")));
        } catch (NumberFormatException e) {
            response.getWriter().append("Nie udalo sie dodac oceny");
        }
        session.setAttribute("grades", grades);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        //formularz
        response.getWriter().append("<form action='' method='post'>" +
                "<input type='text' name='grade'/>" +
                "<input type='submit' value='Dodaj ocene'/>" +
                "</form>");


        HttpSession session = request.getSession();
        if (session.getAttribute("grades") != null) {
            //lista
            List<Integer> grades = (List<Integer>) session.getAttribute("grades");
            response.getWriter().append("Oceny zapisane: <ul>");
            int sum = 0;
            for (Integer grade : grades) {
                sum += grade;
                response.getWriter().append("<li>" + grade + "</li>");
            }
            response.getWriter().append("</ul>");
            //srednia
            response.getWriter().append("Srednia coen to: " + sum / grades.size());
        }


    }
}
