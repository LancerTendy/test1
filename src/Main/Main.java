package manager;

import tasks.Task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InMemoryHistoryManager implements HistoryManager {
    private static class Node {
        Task task;
        Node prev;
        Node next;

        Node(Task task) {
            this.task = task;
        }
    }

    private Node head;
    private Node tail;
    private final Set<Integer> taskIds = new HashSet<>();

    @Override
    public void add(Task task) {
        if (taskIds.add(task.getId())) {
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
    }

    @Override
    public void remove(int id) {
        if (taskIds.remove(id)) {
            Node current = head;
            while (current != null) {
                if (current.task.getId() == id) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    } else {
                        head = current.next; // Удаление головы
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } else {
                        tail = current.prev; // Удаление хвоста
                    }
                    break;
                }
                current = current.next;
            }
        }
    }

    @Override
    public List<Task> getHistory() {
        List<Task> history = new ArrayList<>();
        Node current = head;
        while (current != null) {
            history.add(current.task);
            current = current.next;
        }
        return history;
    }
}
