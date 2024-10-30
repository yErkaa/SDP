package task2;

import java.util.List;

public interface TodoView {
    void displayTodos(List<TodoModel> todos);
    void displayMessage(String message);
    String getTodoDescription();
    int getTodoId();
}
