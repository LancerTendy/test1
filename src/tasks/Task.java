package tasks;

public class Task {
    private int id;
    private String name;
    private TaskStatus status; // Статус задачи
    private Integer epicId; // Для подзадач, если есть

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = TaskStatus.NEW; // По умолчанию статус новой задачи
        this.epicId = null; // По умолчанию подзадача не привязана к эпикам
    }

    public Task(int id, String name, int epicId) {
        this.id = id;
        this.name = name;
        this.status = TaskStatus.NEW; // По умолчанию статус новой подзадачи
        this.epicId = epicId; // Подзадача привязана к эпикам
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Integer getEpicId() {
        return epicId;
    }
}
