package com.gekif.springboot.web.springbootfirstwebapplication.service;

import com.gekif.springboot.web.springbootfirstwebapplication.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUser(String user);
}
