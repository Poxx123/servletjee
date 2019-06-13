package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Math.sqrt;

@WebServlet("/post3")
public class Post3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");

        if (a == null || b == null || c == null || a.isEmpty() || b.isEmpty() || c.isEmpty()) {
            response.getWriter().append("Bledne dane.");
        } else {
            double aD = Double.parseDouble(a);
            double bD = Double.parseDouble(b);
            double cD = Double.parseDouble(c);

            calculate(aD, bD, cD, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    void calculate(double a, double b, double c, HttpServletResponse response) throws IOException {
        if (a == 0) {
            if (a == 0)
                if (b == 0)
                    response.getWriter().append("Rownaie tozsamosciowe");
                else
                    response.getWriter().append("Rownanie sprzeczne");
            else {
                double x;
                x = -b / a;
                System.out.print("Równanie liniowe, x = ");
                response.getWriter().append(String.valueOf(x));
            }
        } else {
            double delta;
            delta = b * b - 4 * a * c;
            if (delta < 0)
                response.getWriter().append("Brak rozwiązań");
            else if (delta == 0) {
                double x;
                x = -b / (2 * a);
                System.out.print("Jedno podwójne rozwiązanie x = ");
                response.getWriter().append(String.valueOf(x));
            } else {
                double x1, x2;
                x1 = (-b + sqrt(delta)) / (2 * a);
                x2 = (-b - sqrt(delta)) / (2 * a);
                System.out.print("x1 = ");
                response.getWriter().append(String.valueOf(x1));
                System.out.print("x2 = ");
                response.getWriter().append(String.valueOf(x2));
            }
        }
    }

}



