package manager;

import tasks.Task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InMemoryHistoryManager implements HistoryManager {
    private Node head; // Указатель на первый узел
    private Node tail; // Указатель на последний узел
    private final Set<Integer> taskIds = new HashSet<>(); // Для уникальности ID задач

    // Внутренний класс для узла списка
    private static class Node {
        Task task; // Ссылка на задачу
        Node prev; // Ссылка на предыдущий узел
        Node next; // Ссылка на следующий узел

        Node(Task task) {
            this.task = task;
        }
    }

    @Override
    public void add(Task task) {
        if (taskIds.add(task.getId())) { // Если задача с таким ID еще не добавлена
            linkLast(task); // Добавляем задачу в конец двусвязного списка
        }
    }

    @Override
    public void remove(int id) {
        if (taskIds.remove(id)) { // Если задача с таким ID была в списке
            // Удаляем задачу из двусвязного списка
            Node current = head;
            while (current != null) {
                if (current.task.getId() == id) {
                    if (current.prev != null) {
                        current.prev.next = current.next; // Связываем предыдущий узел с следующим
                    } else {
                        head = current.next; // Если это голова списка
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev; // Связываем следующий узел с предыдущим
                    } else {
                        tail = current.prev; // Если это хвост списка
                    }
                    break;
                }
                current = current.next; // Переходим к следующему узлу
            }
        }
    }

    @Override
    public List<Task> getHistory() {
        return getTasks(); // Получаем список задач
    }

    // Метод для добавления задачи в конец двусвязного списка
    private void linkLast(Task task) {
        Node newNode = new Node(task); // Создаем новый узел
        if (tail == null) { // Если список пуст
            head = newNode; // Новый узел становится головой
            tail = newNode; // Новый узел также становится хвостом
        } else {
            tail.next = newNode; // Присоединяем новый узел к хвосту
            newNode.prev = tail; // Устанавливаем обратную ссылку
            tail = newNode; // Обновляем хвост
        }
    }

    // Метод для получения всех задач в виде ArrayList
    private List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        Node current = head;
        while (current != null) {
            tasks.add(current.task); // Добавляем задачу в список
            current = current.next; // Переходим к следующему узлу
        }
        return tasks; // Возвращаем список задач
    }
}
