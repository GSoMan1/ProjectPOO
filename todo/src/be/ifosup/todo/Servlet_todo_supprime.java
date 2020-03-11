package be.ifosup.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_todo_supprime", urlPatterns = {"/supTodo"})
public class Servlet_todo_supprime extends HttpServlet {

    private TodoService todoService = new TodoService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // appeler la méthode de suppression
        todoService.supprime(new Todo(request.getParameter("todo"),request.getParameter("categorie")));

        //redirection
        response.sendRedirect("todo");
    }
}
