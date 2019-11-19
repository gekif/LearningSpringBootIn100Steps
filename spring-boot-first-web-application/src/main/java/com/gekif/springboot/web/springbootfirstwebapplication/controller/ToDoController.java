package com.gekif.springboot.web.springbootfirstwebapplication.controller;

import com.gekif.springboot.web.springbootfirstwebapplication.model.Todo;
import com.gekif.springboot.web.springbootfirstwebapplication.service.LoginService;
import com.gekif.springboot.web.springbootfirstwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class ToDoController {

    @Autowired
    TodoService service;

    @RequestMapping(value= "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String name = (String) model.get("name");
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value= "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo(0,
                (String) model.get("name"), "", new Date(),
                false));
        return "todo";
    }

    @RequestMapping(value= "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, Todo todo) {
        service.addTodo((String) model.get("name"), todo.getDesc(), new Date(),
                false);
        return "redirect:/list-todos";
    }


}
