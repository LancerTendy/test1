public class Main {
    public static void main(String[] args) {
        Epic epic = new Epic(1, "Epic Task");
        Subtask subtask1 = new Subtask(101, "Subtask 1", epic.getId());
        Subtask subtask2 = new Subtask(102, "Subtask 2", epic.getId());

        epic.addSubtask(subtask1.getId());
        epic.addSubtask(subtask2.getId());

        System.out.println("Epic: " + epic.getName());
        System.out.println("Subtask IDs: " + epic.getSubtaskIds());

        epic.removeSubtask(subtask1.getId());
        System.out.println("Subtask IDs after removal: " + epic.getSubtaskIds());
    }
}
