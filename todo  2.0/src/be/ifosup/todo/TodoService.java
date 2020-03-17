package be.ifosup.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo("Apprendre le Java", "Formations"));
        todos.add(new Todo("Préparer un Steak", "Formations"));
        todos.add(new Todo("Manger le Steak", "TaMereMaxime"));
    }

    public List<Todo> recupereTodo() {
        return todos;
    }

    public void ajouteTodo(Todo todo) {
        todos.add(todo);
    }

    public void supprimeTodo(Todo todo){
        todos.remove(todo);
    }

}
