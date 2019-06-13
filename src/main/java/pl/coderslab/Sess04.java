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

@WebServlet("/sess04")
public class Sess04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nazwa = request.getParameter("nazwa");
        String ilosc = request.getParameter("ilosc");
        String cena = request.getParameter("cena");

        if (nazwa == null || ilosc == null || cena == null
                || nazwa.isEmpty() || ilosc.isEmpty() || cena.isEmpty()) {
            response.getWriter().append("Bledny produkt");
        } else {
            HttpSession session = request.getSession();
            List<CartItem> cart;
            if (session.getAttribute("cart") == null) {
                cart = new ArrayList<>();
            } else {
                cart = (List<CartItem>) session.getAttribute("cart");
            }
            try {
                cart.add(new CartItem(nazwa, Integer.parseInt(ilosc), Double.parseDouble(cena)));
                response.getWriter().append("Dodano produkt.\n");
            } catch (NumberFormatException e) {
                response.getWriter().append("Zle dane w produkcie.");
            }
            session.setAttribute("cart", cart);
            response.getWriter().append("\nTwoje produkty: \n");
            cart.stream().forEach(x -> {
                try {
                    response.getWriter().append(x.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/sess04.html").forward(request, response);
    }

    protected class CartItem {
        String name;
        int quantity;
        double price;

        public CartItem(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " - " + quantity + " x " + price + " = " + quantity * price + "zl";
        }
    }
}
