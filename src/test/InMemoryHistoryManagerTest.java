package test;

import manager.Manager;
import manager.InMemoryHistoryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.Task;

import java.util.List;

public class InMemoryHistoryManagerTest {

    private InMemoryHistoryManager historyManager;
    private Task task1;
    private Task task2;

    @BeforeEach
    public void setUp() {
        historyManager = Manager.createHistoryManager(); // Создаем экземпляр через метод Manager
        task1 = new Task(1, "Test Task 1");
        task2 = new Task(2, "Test Task 2");
    }

    @Test
    public void testAddAndGetHistory() {
        historyManager.add(task1);
        historyManager.add(task2);

        List<Task> history = historyManager.getHistory();
        Assertions.assertEquals(2, history.size());
        Assertions.assertEquals(task1.getId(), history.get(0).getId());
        Assertions.assertEquals(task2.getId(), history.get(1).getId());
    }

    @Test
    public void testRemoveTask() {
        historyManager.add(task1);

        historyManager.remove(task1.getId());
        List<Task> history = historyManager.getHistory();
        Assertions.assertEquals(0, history.size());
    }
}
