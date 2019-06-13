package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/sess06")
public class Sess06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int[] liczby = (int[]) session.getAttribute("numbers");

        int add = 0, sub = 0, mul = 0;
        String addS = request.getParameter("add");
        String subS = request.getParameter("sub");
        String mulS = request.getParameter("mul");

        if (addS == null || subS == null || mulS == null || addS.isEmpty() || subS.isEmpty() || mulS.isEmpty()) {
            response.getWriter().append("Try again.");
            doGet(request, response);
        } else {
            try {
                add = Integer.parseInt(addS);
                sub = Integer.parseInt(subS);
                mul = Integer.parseInt(mulS);
            } catch (NumberFormatException e) {
                response.getWriter().append("Wynik musi byc liczba calkowita.");
                doGet(request, response);
            }
        }

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("<form action='' method='post'>" +
                liczby[0] + " + " + liczby[1] + "=" + add);
        if (liczby[0] + liczby[1] == add) {
            response.getWriter().append("Correct</br>");
        } else {
            response.getWriter().append("Wrong</br>");
        }
        response.getWriter().append(liczby[0] + " - " + liczby[1] + "=" + sub);
        if (liczby[0] - liczby[1] == add) {
            response.getWriter().append("Correct</br>");
        } else {
            response.getWriter().append("Wrong</br>");
        }
        response.getWriter().append(liczby[0] + " * " + liczby[1] + "=" + mul);
        if (liczby[0] * liczby[1] == add) {
            response.getWriter().append("Correct</br>");
        } else {
            response.getWriter().append("Wrong</br>");
        }
        response.getWriter().append("<a href='/sess06'>Try again.</a>" +
                "</form>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random rand = new Random();
        int[] liczby = {(rand.nextInt(980) + 20), (rand.nextInt(980) + 20)};

        HttpSession session = request.getSession();
        session.setAttribute("numbers", liczby);
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("<form action='' method='post'>" +
                liczby[0] + " + " + liczby[1] + "=" +
                "<input type='number' name='add'/></br>" +
                liczby[0] + " - " + liczby[1] + "=" +
                "<input type='number' name='sub'/></br>" +
                liczby[0] + " * " + liczby[1] + "=" +
                "<input type='number' name='mul'/></br>" +
                "<input type='submit' value='Check'/></br>" +
                "</form>"
        );
    }
}
