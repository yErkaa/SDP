package task2;

public class TodoModel {
    private int id;
    private String description;
    private boolean completed;

    public TodoModel(int id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;  // default is incomplete
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }
}
