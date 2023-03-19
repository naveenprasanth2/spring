package com.androstays.myfirstwebapp.todo;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class TodoService {
    public static List<Todo> todos;
    public static int todosCount;

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(++todosCount, "in28minutes", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn Full Stack Development",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String userName, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(getTodosList().size() + 1, userName, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        todos.stream().filter(x -> x.getId() == id).findFirst().ifPresent(todos::remove);
    }

    public Todo findById(int id) {
        return todos.stream().filter(x -> x.getId() == id).findFirst().stream().toList().get(0);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo.getId() - 1, todo);

    }

    public List<Todo> getTodosList() {
        return todos;
    }
}
