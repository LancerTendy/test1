package tasks;

import tasks.Task;

// Класс для узла двусвязного списка
public class Node {
    private Task task; // Ссылка на задачу
    private Node prev; // Ссылка на предыдущий узел
    private Node next; // Ссылка на следующий узел

    public Node(Task task) {
        this.task = task;
    }

    // Геттер для задачи
    public Task getTask() {
        return task;
    }

    // Геттер и сеттер для предыдущего узла
    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    // Геттер и сеттер для следующего узла
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
