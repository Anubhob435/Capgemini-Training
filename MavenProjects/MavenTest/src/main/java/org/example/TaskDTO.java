package org.example;

import java.util.Objects;

public class TaskDTO {

    private Long id;
    private String task;
    private String description;

    // Default constructor
    public TaskDTO() {
    }

    // Constructor without ID (useful for create operations)
    public TaskDTO(String task, String description) {
        this.task = task;
        this.description = description;
    }

    // Full constructor
    public TaskDTO(Long id, String task, String description) {
        this.id = id;
        this.task = task;
        this.description = description;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // equals() - useful for comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDTO)) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id) &&
                Objects.equals(task, taskDTO.task) &&
                Objects.equals(description, taskDTO.description);
    }

    // hashCode() - required when equals() is overridden
    @Override
    public int hashCode() {
        return Objects.hash(id, task, description);
    }

    // toString()
    @Override
    public String toString() {
        return "ID: " + id +
                "\tTask: " + task +
                "\tDescription: " + description;
    }
}

