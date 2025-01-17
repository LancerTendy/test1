package tasks;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private final List<Integer> subtaskIds; // Список идентификаторов подзадач

    public Epic(int id, String name) {
        super(id, name);
        this.subtaskIds = new ArrayList<>(); // Инициализация списка подзадач
    }

    // Метод для добавления подзадачи
    public void addSubtask(int subtaskId) {
        subtaskIds.add(subtaskId);
    }

    // Метод для удаления подзадачи
    public void removeSubtask(int subtaskId) {
        subtaskIds.remove(Integer.valueOf(subtaskId));
    }

    // Метод для получения списка подзадач
    public List<Integer> getSubtaskIds() {
        return new ArrayList<>(subtaskIds); // Возвращаем копию списка подзадач
    }
}
