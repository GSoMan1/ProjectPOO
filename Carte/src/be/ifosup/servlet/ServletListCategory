package be.ifosup.servlet;

import be.ifosup.db.ServiceCategories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDelCategory" ,urlPatterns = {"/delcategory"})
public class ServletDelCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("delcategory");
        try {
            ServiceCategories.delcategory(id);
        } catch ( SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./listCategory");
    }
    }
