package com.androstays.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@SessionAttributes("name")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("in28minutes");
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String userName = (String) model.getAttribute("name");
        Todo todo = new Todo(0, userName, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String userName = (String) model.getAttribute("name");
        todoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        IntStream.range(0, todoService.getTodosList().size()).forEach(x -> todoService.getTodosList().get(x).setId(x + 1));
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors())
            return "todo";
        if (model.getAttribute("localDate") == null) {
            model.put("localDate", todo.getTargetDate());
        }
        todo.setUsername((String) model.getAttribute("username"));
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
