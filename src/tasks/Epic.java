package tasks;

import java.util.ArrayList;
import java.util.List;

// tasks.Epic.java
public class Epic extends Task {
    private List<Subtask> subtasks; // Список подзадач

    public Epic(int id, String name) {
        super(id, name);
        this.subtasks = new ArrayList<>(); // Инициализация списка подзадач
    }

    // Метод для добавления подзадачи
    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
    }

    // Метод для получения списка подзадач
    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    // Метод для удаления подзадачи
    public void removeSubtask(Subtask subtask) {
        subtasks.remove(subtask);
    }

    // Другие методы, если необходимо
}
