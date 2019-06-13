package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/post2")
public class Post2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String text = request.getParameter("text");
        String[] vulgarisms = {"cholera", "kurwa", "dupa"};
        if(text == null || text.isEmpty()){
            response.getWriter().append("Wrong data.");
        } else{
            if(request.getParameter("checkbox") == null) {
                String[] split = text.split(" ");
                for (String word : split) {
                    if (Arrays.stream(vulgarisms).anyMatch(word::equals)) {
                        response.getWriter().append(word.replaceAll("[a-zA-Z]", "*") + " ");
                    } else {
                        response.getWriter().append(word + " ");
                    }
                }
            } else{
                response.getWriter().append(text);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
