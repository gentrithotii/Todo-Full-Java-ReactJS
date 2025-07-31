package com.gentrit.todo.service;

import com.gentrit.todo.dto.TodoDTO;
import com.gentrit.todo.dto.UserDTO;
import com.gentrit.todo.dto.UserRegisterDTO;

import java.util.Optional;

public interface TodoService{
Optional<TodoDTO> addTodoToUser(UserDTO user, TodoDTO todo);

}
