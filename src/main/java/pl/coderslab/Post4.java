package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

@WebServlet("/post4")
public class Post4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] numbers = request.getParameterValues("numbers");
        Set<Double> set = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if(!(numbers[i] == null || numbers[i].isEmpty())){
                try{
                    set.add(Double.parseDouble(numbers[i]));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        set.stream().forEach(x -> {
            try {
                response.getWriter().append(x.toString() + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/post4.html").forward(request, response);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.append("<form action='' method='post'>");
        Random rand = new Random();
        int max = rand.nextInt(5)+5;

        for (int i = 0; i <=max; i++) {
            pw.append("<input type='number' name='numbers'/><br/>");
        }

        pw.append("<input type='submit' value='Wyslij'/>");
        pw.append("</form>");
    }
}
