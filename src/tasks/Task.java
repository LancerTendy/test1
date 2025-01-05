package tasks;

// tasks.Task.java
public class Task {
    private int id;
    private String name;
    private String description; // Описание задачи
    private TaskStatus status; // Статус задачи

    public Task(int id, String name, String description, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}

// Enum для статуса задачи
enum TaskStatus {
    NEW, IN_PROGRESS, COMPLETED, BLOCKED
}
