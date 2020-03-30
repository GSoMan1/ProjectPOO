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

@WebServlet(name = "ServletEditCategory" , urlPatterns = {"/editcategory"})
public class ServletEditCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int catid = parseInt(request.getParameter("catid"));
            request.setAttribute("categories", ServiceCategories.GetCategory());
            request.setAttribute("dishes", ServiceDishes.GetDishes(catid));
            request.setAttribute("category", ServiceCategories.GetCategoryByID(catid));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/editcategory.jsp").forward(request, response);
    }
}
