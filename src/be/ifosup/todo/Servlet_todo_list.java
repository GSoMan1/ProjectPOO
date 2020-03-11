package be.ifosup.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_todo_list", urlPatterns = {"/todo"})
public class Servlet_todo_list extends HttpServlet {

    //création d'une instance de todoService
    private TodoService todoService = new TodoService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //récupérer les Todos
        request.setAttribute("todos",todoService.recupereTodo());

        //afficher la page
        request.getRequestDispatcher("/views/todolist.jsp").forward(request,response);
    }
}
