package service;

import model.Task;

public class Node {
    private final Task task; // Задача, хранящаяся в узле
    private Node prev; // Ссылка на предыдущий узел
    private Node next; // Ссылка на следующий узел

    public Node(Task task) {
        this.task = task;
        this.prev = null;
        this.next = null;
    }

    // Геттер для задачи
    public Task getTask() {
        return task;
    }

    // Геттер для предыдущего узла
    public Node getPrev() {
        return prev;
    }

    // Сеттер для предыдущего узла
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    // Геттер для следующего узла
    public Node getNext() {
        return next;
    }

    // Сеттер для следующего узла
    public void setNext(Node next) {
        this.next = next;
    }
}
