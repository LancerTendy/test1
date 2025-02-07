package service;

import model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryManager implements HistoryManager {

    private final Map<Integer, Node> taskMap; // Хранение узлов для быстрого доступа
    private Node head; // Начало списка
    private Node tail; // Конец списка

    public InMemoryHistoryManager() {
        this.taskMap = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    // Внутренний класс Node (не вложенный)
    private static class Node {
        private final Task task; // Соблюдаем принцип инкапсуляции
        private Node prev; // Ссылка на предыдущий узел
        private Node next; // Ссылка на следующий узел

        Node(Task task) {
            this.task = task;
            this.prev = null;
            this.next = null;
        }

        public Task getTask() {
            return task;
        }
    }

    // Метод для добавления задачи в конец списка
    private void linkLast(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Метод для получения списка задач
    private List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        Node current = head;
        while (current != null) {
            tasks.add(current.getTask());
            current = current.next;
        }
        return tasks;
    }

    // Метод для удаления узла из списка
    private void removeNode(Node node) {
        if (node == null) {
            return;
        }

        // Обновляем ссылки соседних узлов
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // Если удаляемый узел — голова
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // Если удаляемый узел — хвост
        }
    }

    @Override
    public void add(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        // Если задача уже есть в истории, удаляем её
        if (taskMap.containsKey(task.getId())) {
            removeNode(taskMap.get(task.getId()));
        }

        // Добавляем задачу в конец списка
        linkLast(task);
        taskMap.put(task.getId(), tail); // Сохраняем узел в карту
    }

    @Override
    public void remove(int id) {
        if (taskMap.containsKey(id)) {
            Node nodeToRemove = taskMap.get(id);
            removeNode(nodeToRemove); // Удаляем узел из списка
            taskMap.remove(id); // Удаляем узел из карты
        }
    }

    @Override
    public List<Task> getHistory() {
        return getTasks(); // Возвращаем список задач
    }
}
