package be.ifosup.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo("Apprendre le Java","Formations"));
        todos.add(new Todo("Préparer une pizza","Formations"));
        todos.add(new Todo("Manger la pizza","Slurp"));
    }

    public List<Todo> recupereTodo(){
        return todos;
    }

    public void ajouteTodo(Todo todo){
        todos.add(todo);
    }

    public void supprime(Todo todo){
        todos.remove(todo);
    }
}
