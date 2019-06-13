package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean found = false;
        if(cookies != null){
            for (Cookie c : cookies) {
                if("cookie51".equals(c.getName())){
                    c.setMaxAge(0);
                    response.addCookie(c);
                    response.getWriter().append("Witamy na stronie Cookie52");
                    found = true;
                }
            }
        }
        if(!found){
            String message = "Nie odwiedziles jeszcze tej strony";
            response.sendRedirect("cookie51?msg=" + URLEncoder.encode(message));
        }
    }
}
