package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get3")
public class Get3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String width = request.getParameter("width");
        String height = request.getParameter("height");
        int widthInt = 5;
        int heightInt = 10;

        if (!(width == null || height == null || width.isEmpty() || height.isEmpty())) {
            try {
                widthInt = Integer.parseInt(width);
                heightInt = Integer.parseInt(height);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int[][] arr = new int[heightInt + 1][widthInt + 1];
        for (int i = 1; i < widthInt; i++) {
            arr[0][i] = i;
        }
        for (int i = 1; i < heightInt; i++) {
            arr[i][0] = i;
        }

        for (int i = 1; i < heightInt; i++) {
            for (int j = 1; j < widthInt; j++) {
                arr[i][j] = i * j;
            }
        }

        for (int i = 0; i < heightInt; i++) {
            response.getWriter().append("\n");
            for (int j = 0; j < widthInt; j++) {
                if (i >= 1 && j >= 1) {
                    response.getWriter().append(arr[i][j] + "  ");
                } else {
                    response.getWriter().append(arr[i][j] + "  ");
                }

            }
        }


    }
}
