package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mvc14")
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String title = request.getParameter("title" + i);
            String author = request.getParameter("author" + i);
            String isbn = request.getParameter("isbn" + i);
            if (title == null || author == null || isbn == null || title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                response.getWriter().append("Nie udalo sie stworzyc obiektu. Bledne dane.");
            } else {
                Book book = new Book(title, author, isbn);
                books.add(book);
            }
        }
        request.setAttribute("books", books);
        request.getRequestDispatcher("/result14.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp14.jsp").forward(request, response);
    }
}
