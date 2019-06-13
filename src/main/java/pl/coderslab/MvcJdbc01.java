package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-book")
public class MvcJdbc01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        if(title == null || author == null || isbn == null || title.isEmpty() || author.isEmpty() || isbn.isEmpty()){
            response.getWriter().append("Nie udalo sie stworzyc obiektu. Bledne dane.");
        } else {
            Book book = new Book(title,author,isbn);
            request.setAttribute("book", book);
            request.getRequestDispatcher("/result13.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/mvcjdbc1.html");
    }
}
