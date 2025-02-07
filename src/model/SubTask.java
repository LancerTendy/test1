package model;

import java.util.Objects;

public class SubTask extends Task {
    private int epicId; // ID эпика, к которому относится подзадача

    // Конструктор
    public SubTask(String name, String description, int epicId) {
        super(name, description);
        this.epicId = epicId;
    }

    // Геттер для epicId
    public Integer getEpicId() {
        return epicId;
    }

    // Сеттер для epicId
    public Integer setEpicId(int epicId) {
        this.epicId = epicId;
        return null; // Возвращает null, что может быть не лучшим решением. Рассмотрите возвращение void.
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return super.toString() + " EpicId: " + epicId;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SubTask subTask = (SubTask) obj;
        return super.equals(obj) && epicId == subTask.epicId;
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), epicId);
    }
}
