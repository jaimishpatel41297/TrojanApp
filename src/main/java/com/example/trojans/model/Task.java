package com.example.trojans.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Task {
    private String name;
    private boolean isCompleted;
    private Priority priority;
    private LocalDate date;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public Task() {
        this.priority = Priority.LOW;
        this.date = LocalDate.now();
    }

    public Task(String name) {
        this.name = name;
        this.priority = Priority.LOW;
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(int priority) throws Exception {
        this.priority = Priority.valueOf(priority);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
