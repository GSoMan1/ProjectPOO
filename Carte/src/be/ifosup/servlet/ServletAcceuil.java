package be.ifosup.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import be.ifosup.db.*;
import java.sql.SQLException;

@WebServlet(name = "ServletAcceuil" , urlPatterns = {"/"})
public class ServletAcceuil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("in servacc");
            request.setAttribute("categories", ServiceCategories.GetCategory());
            request.setAttribute("dishes", ServiceDishes.GetDishes(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/acceuil.jsp").forward(request, response);
    }
}
