package task2;

import java.util.List;
import java.util.Scanner;

public class TodoViewImpl implements TodoView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayTodos(List<TodoModel> todos) {
        System.out.println("Todo List:");
        for (TodoModel todo : todos) {
            String status = todo.isCompleted() ? "[Completed]" : "[Pending]";
            System.out.println(todo.getId() + ": " + todo.getDescription() + " " + status);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getTodoDescription() {
        System.out.print("Enter todo description: ");
        return scanner.nextLine();
    }

    @Override
    public int getTodoId() {
        System.out.print("Enter todo ID: ");
        return scanner.nextInt();
    }
}
