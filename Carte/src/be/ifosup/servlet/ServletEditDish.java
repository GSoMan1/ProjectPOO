package be.ifosup.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import be.ifosup.db.*;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "ServletEditDish" , urlPatterns = {"/editdish"})
public class ServletEditDish extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int dishid = parseInt(request.getParameter("dishid"));
            request.setAttribute("categories", ServiceCategories.GetCategory());
            request.setAttribute("dish", ServiceDishes.GetDishByID(dishid));
            request.setAttribute("catid", parseInt(request.getParameter("catid")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/editdish.jsp").forward(request, response);
    }
}
