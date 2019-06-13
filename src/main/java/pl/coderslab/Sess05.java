package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/sess05")
public class Sess05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String captcha = request.getParameter("captcha");
        if (captcha == null || captcha.isEmpty()) {
            response.getWriter().append("Bledna suma.");
            doGet(request, response);
        } else {
            try {
                int suma = Integer.parseInt(captcha);
                HttpSession session = request.getSession();
                if (suma == (int) session.getAttribute("captcha")) {
                    response.getWriter().append("Poprawna suma.");
                } else {
                    response.getWriter().append("Bledna suma.");
                    doGet(request, response);
                }
            } catch (NumberFormatException e) {
                response.getWriter().append("Bledny format sumy.");
                doGet(request, response);
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("<form action='' method='post'>" +
                "    Imie:" +
                "    <input type='text' name='name'/></br>" +
                "    Nazwisko:" +
                "    <input type='text' name='surname'/></br>" +
                "    Email:" +
                "    <input type='text' name='email'/></br>"
        );

        Random rand = new Random();
        int liczba1 = rand.nextInt(100);
        int liczba2 = rand.nextInt(100);
        int suma = liczba1 + liczba2;
        HttpSession session = request.getSession();
        session.setAttribute("captcha", suma);
        response.getWriter().append("Wpisz ponizej sume " + liczba1 + " + " + liczba2 + "</br>");
        response.getWriter().append("Captcha:" +
                "<input type='number' name='captcha'/></br>" +
                "<input type='submit'/>" +
                "</form>");
    }
}
