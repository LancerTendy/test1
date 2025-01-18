package tasks;

public class Task {
    private int id;
    private String name;
    private Status status; // Статус задачи

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = Status.NEW; // По умолчанию статус новой задачи
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
