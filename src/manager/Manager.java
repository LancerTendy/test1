package manager;

import tasks.Task;

import java.util.List;

public class Manager {
    private final InMemoryHistoryManager historyManager;

    public Manager() {
        this.historyManager = new InMemoryHistoryManager(); // Инициализация менеджера истории
    }

    // Метод для добавления задачи
    public void addTask(Task task) {
        historyManager.add(task);
    }

    // Метод для удаления задачи по ID
    public void removeTask(int id) {
        historyManager.remove(id);
    }

    // Метод для получения истории задач
    public List<Task> getTaskHistory() {
        return historyManager.getHistory();
    }
}
