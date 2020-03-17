package be.ifosup.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletLogin" , urlPatterns = {"/"})
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperer les 2 champs formulaires
        String nom = request.getParameter("nom");
        String pass = request.getParameter("pass");
        //vérification
        try {
            if (LoginDAO.valid(nom, pass)) {
                request.getSession().setAttribute("nom", nom);
                System.out.println("OK");
                response.sendRedirect("todo");
            } else {
                request.setAttribute("errorMessage", "Login/Pass Invalid");
                request.getRequestDispatcher("/views/login.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
}
