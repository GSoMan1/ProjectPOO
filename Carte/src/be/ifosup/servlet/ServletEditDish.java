package be.ifosup.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import be.ifosup.db.*;
import be.ifosup.entities.Category;
import be.ifosup.entities.Dish;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "ServletEditDish" , urlPatterns = {"/editdish"})
public class ServletEditDish extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishid = parseInt(request.getParameter("dishid"));
        String dishtitle = request.getParameter("dishtile");
        String dishdescription = request.getParameter("dishdescription");
        float dishprice = Float.parseFloat(request.getParameter("dishprice"));
        int catid = parseInt(request.getParameter("dishcatid"));
        Category category = null;
        try {
            category = ServiceCategories.GetCategoryByID(catid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dish dish = new Dish(dishtitle, dishdescription, dishprice, dishid, category);
        try {
            ServiceDishes.editDishes(dish);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("./");
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
