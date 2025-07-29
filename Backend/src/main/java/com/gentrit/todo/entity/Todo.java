package com.gentrit.todo.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true)
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column()
    private String description;

    @Column(nullable = false)
    private LocalDateTime dueDate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Todo() {
    }

    public Todo(String title, String description, LocalDateTime dueDate) {
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
    }
    @PrePersist
    public void onCreation(){
        setCreatedAt(LocalDateTime.now());
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
