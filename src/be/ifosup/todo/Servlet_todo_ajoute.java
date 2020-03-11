package be.ifosup.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_todo_ajoute", urlPatterns = {"/add-todo"})
public class Servlet_todo_ajoute extends HttpServlet {

    private TodoService todoService = new TodoService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Recuperation des champs
        String nouveauTodo = request.getParameter("todo");
        String categorie = request.getParameter("categorie");

        // ajout d'un todo
        todoService.ajouteTodo( new Todo(nouveauTodo, categorie) );

        //redirection
        response.sendRedirect("todo");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/todoAdd.jsp").forward(request,response);
    }
}
