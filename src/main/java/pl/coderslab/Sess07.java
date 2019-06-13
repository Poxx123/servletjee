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

@WebServlet("/sess07")
public class Sess07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        List<String> capitals = new ArrayList<>();
        capitals.add("Moskwa");
        capitals.add("Wilno");
        capitals.add("Minsk");
        capitals.add("Kijow");
        capitals.add("Bratyslawa");
        capitals.add("Praga");
        capitals.add("Berlin");

        HttpSession session = request.getSession();
        int points = 0;
        if (session.getAttribute("points") != null) {
            points = (int) session.getAttribute("points");
        }
        int index = (int) session.getAttribute("index");
        if (index == 7) {
            response.getWriter().append("Twoj wynik to: " + points + "/7\n");
            session.setAttribute("index", null);
            session.setAttribute("points", null);
            response.getWriter().append("Kolejna proba.\n");
            doGet(request, response);
        }
        String answer = request.getParameter("answer");
        if (answer == null || answer.isEmpty()) {
            response.getWriter().append("Brak odpowiedzi.");
            doGet(request, response);
        } else {
            if (answer.equals(capitals.get(index))) {
                points++;
                session.setAttribute("points", points);
            }
            session.setAttribute("index", ++index);
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> countries = new ArrayList<>();
        countries.add("Rosja");
        countries.add("Litwa");
        countries.add("Bialorus");
        countries.add("Ukraina");
        countries.add("Slowacja");
        countries.add("Czechy");
        countries.add("Niemcy");


        HttpSession session = request.getSession();
        int index = -1;
        if (session.getAttribute("index") == null) {
            index = 0;
        } else if ((int) session.getAttribute("index") == 7) {
            doPost(request, response);
        } else {
            index = (int) session.getAttribute("index");
        }
        session.setAttribute("index", index);
        session.setAttribute("country", countries);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("<form action='' method='post'>" +
                "Podaj stolice panstwa: ");
        response.getWriter().append(countries.get(index) + "</br>" +
                "<input type='text' name='answer'/>" +
                "</form>");
    }
}
