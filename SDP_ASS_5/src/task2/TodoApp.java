package task2;

import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        TodoView view = new TodoViewImpl();
        TodoController controller = new TodoController(view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTodo List Application");
            System.out.println("1. Add Todo");
            System.out.println("2. View Todos");
            System.out.println("3. Delete Todo");
            System.out.println("4. Toggle Todo Completion");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    controller.addTodo();
                    break;
                case 2:
                    controller.viewTodos();
                    break;
                case 3:
                    controller.deleteTodo();
                    break;
                case 4:
                    controller.toggleTodoCompleted();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
