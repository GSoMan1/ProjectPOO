package be.ifosup.servlet;

import be.ifosup.db.ServiceCategories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletListCategory",urlPatterns = "/listCategory")
public class ServletListCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("categories", ServiceCategories.getCategories());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/listcategory.jsp").forward(request, response);
    }
}
