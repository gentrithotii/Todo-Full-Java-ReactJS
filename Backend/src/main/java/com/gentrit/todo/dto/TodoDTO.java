package com.gentrit.todo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class TodoDTO {
    private String title;
    private String description;
    private LocalDateTime dueDate;

    public TodoDTO(String title, String description, LocalDateTime dueDate){
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
    }
}
