package be.ifosup.servlet;

import be.ifosup.db.ServiceDishes;
import be.ifosup.entities.Dish;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDelDish" , urlPatterns = {"/deldish"})
public class ServletDelDish extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("deldish");
        try {
            ServiceDishes.deldish(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./");
    }
}
