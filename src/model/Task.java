package model;

import java.util.Objects;

public class Task {
    protected String name;
    protected String description;
    protected int id;
    protected TaskStatus status;

    // Конструктор с именем и описанием
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = TaskStatus.NEW; // Статус по умолчанию — NEW
    }

    // Конструктор с именем, описанием и статусом
    public Task(String name, String description, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    // Конструктор по умолчанию
    public Task() {
        this.name = "";
        this.description = "";
        this.status = TaskStatus.NEW; // Заменяем TODO на NEW
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для имени
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для описания
    public String getDescription() {
        return description;
    }

    // Сеттер для описания
    public void setDescription(String description) {
        this.description = description;
    }

    // Геттер для ID
    public int getId() {
        return id;
    }

    // Сеттер для ID
    public void setId(int id) {
        this.id = id;
    }

    // Геттер для статуса
    public TaskStatus getStatus() {
        return status;
    }

    // Сеттер для статуса
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && status == task.status;
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, description, id, status);
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
