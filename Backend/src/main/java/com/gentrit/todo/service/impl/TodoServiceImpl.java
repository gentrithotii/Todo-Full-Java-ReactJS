package com.gentrit.todo.service.impl;

import com.gentrit.todo.dto.TodoDTO;
import com.gentrit.todo.dto.UserDTO;
import com.gentrit.todo.repository.TodoRepository;
import com.gentrit.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }


    @Override
    public Optional<TodoDTO> addTodoToUser(UserDTO user, TodoDTO todo) {

        return Optional.empty();
    }
}
