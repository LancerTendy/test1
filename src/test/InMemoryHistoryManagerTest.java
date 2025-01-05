package test;

import manager.InMemoryHistoryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryHistoryManagerTest {

    private InMemoryHistoryManager historyManager;
    private Task task1;
    private Task task2;

    @BeforeEach
    public void setUp() {
        // Создание экземпляра historyManager через метод класса Manager
        historyManager = Manager.createInMemoryHistoryManager(); // Предположим, что такой метод существует
        task1 = new Task(1, "Test Task 1", "Description for Task 1", TaskStatus.NEW);
        task2 = new Task(2, "Test Task 2", "Description for Task 2", TaskStatus.NEW);
    }

    @Test
    public void testAddAndGetHistory() {
        historyManager.add(task1);
        historyManager.add(task2);

        List<Task> history = historyManager.getHistory();
        assertEquals(2, history.size());
        assertEquals(task1.getId(), history.get(0).getId());
        assertEquals(task2.getId(), history.get(1).getId());
    }

    @Test
    public void testRemoveTask() {
        historyManager.add(task1);

        historyManager.remove(task1.getId());
        List<Task> history = historyManager.getHistory();
        assertEquals(0, history.size());
    }
}
