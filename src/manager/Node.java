package manager;

import tasks.Task;

class Node {
    private Task task; // Сделаем поле private для соблюдения инкапсуляции
    private Node prev; // Предыдущий узел
    private Node next; // Следующий узел

    // Конструктор
    public Node(Task task) {
        this.task = task;
    }

    // Геттеры и сеттеры для полей
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
