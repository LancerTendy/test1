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

    // Метод для добавления задачи в конец списка
    private void linkLast(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    // Метод для получения списка задач
    private List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        Node current = head;
        while (current != null) {
            tasks.add(current.getTask());
            current = current.getNext();
        }
        return tasks;
    }

    // Метод для удаления узла из списка
    private void removeNode(Node node) {
        if (node == null) {
            return;
        }

        // Обновляем ссылки соседних узлов
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext(); // Если удаляемый узел — голова
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev(); // Если удаляемый узел — хвост
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
