package be.ifosup.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import be.ifosup.db.*;
import be.ifosup.entities.Category;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "ServletEditCategory" , urlPatterns = {"/editcategory"})
public class ServletEditCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8" );
        response.setCharacterEncoding("UTF-8" );
        int catid = parseInt(request.getParameter("categoryid"));
        String catname = request.getParameter("catname");
        Category category = new Category(catid, catname);
        try {
            ServiceCategories.editCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("./listCategory");
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int catid = parseInt(request.getParameter("catid"));
            request.setAttribute("categories", ServiceCategories.getCategories());
            request.setAttribute("dishes", ServiceDishes.getDishes(catid));
            if (catid != 0)
                request.setAttribute("category", ServiceCategories.getCategoryByID(catid));
            else
                request.setAttribute("category", new Category(0, null));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/editcategory.jsp").forward(request, response);
    }
}
