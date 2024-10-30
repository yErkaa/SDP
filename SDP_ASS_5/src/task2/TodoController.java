package task2;

import java.util.ArrayList;
import java.util.List;

public class TodoController {
    private final TodoView view;
    private final List<TodoModel> todos = new ArrayList<>();
    private int nextId = 1;

    public TodoController(TodoView view) {
        this.view = view;
    }

    public void addTodo() {
        String description = view.getTodoDescription();
        TodoModel todo = new TodoModel(nextId++, description);
        todos.add(todo);
        view.displayMessage("Todo added successfully.");
    }

    public void viewTodos() {
        view.displayTodos(todos);
    }

    public void deleteTodo() {
        int id = view.getTodoId();
        TodoModel todoToRemove = null;
        for (TodoModel todo : todos) {
            if (todo.getId() == id) {
                todoToRemove = todo;
                break;
            }
        }
        if (todoToRemove != null) {
            todos.remove(todoToRemove);
            view.displayMessage("Todo removed successfully.");
        } else {
            view.displayMessage("Todo not found.");
        }
    }

    public void toggleTodoCompleted() {
        int id = view.getTodoId();
        for (TodoModel todo : todos) {
            if (todo.getId() == id) {
                todo.toggleCompleted();
                view.displayMessage("Todo status updated.");
                return;
            }
        }
        view.displayMessage("Todo not found.");
    }
}
