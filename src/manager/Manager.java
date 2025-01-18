package manager;

import tasks.Task;
import java.util.List;

public class Manager {
    // Метод для создания и получения экземпляра InMemoryTaskManager
    public static TaskManager createTaskManager() {
        return new InMemoryTaskManager(); // Возвращаем экземпляр InMemoryTaskManager
    }

    // Метод для создания и получения экземпляра InMemoryHistoryManager
    public static InMemoryHistoryManager createHistoryManager() {
        return new InMemoryHistoryManager(); // Возвращаем экземпляр InMemoryHistoryManager
    }
}
