package com.gekif.springboot.web.springbootfirstwebapplication.controller;

import com.gekif.springboot.web.springbootfirstwebapplication.service.LoginService;
import com.gekif.springboot.web.springbootfirstwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {

    @Autowired
    TodoService service;


    @RequestMapping(value= "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        model.put("todos", service.retrieveTodos("gekif"));
        return "list-todos";
    }


}
