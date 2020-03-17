package be.ifosup.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletTodo_ajoute", urlPatterns = {"/add-todo"})

public class Servlet_todo_ajoute extends HttpServlet {

    private TodoService todoService = new TodoService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // force l'UTF8
        request.setCharacterEncoding("UTF-8");

        // récupération du champs dans le formulaire
        String nouveauTodo = request.getParameter("todo");
        String categorie = request.getParameter("categorie");

        // ajouter au todos
        todoService.ajouteTodo( new Todo(nouveauTodo, categorie));

        // redirection avec la méthode get!
        response.sendRedirect("todo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/todoAdd.jsp").forward(request, response);
    }
}