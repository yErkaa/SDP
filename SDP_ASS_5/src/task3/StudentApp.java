package task3;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        StudentView view = new StudentViewImpl();
        StudentViewModel viewModel = new StudentViewModel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management Application");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    String name = view.getStudentName();
                    int age = view.getStudentAge();
                    String course = view.getStudentCourse();
                    viewModel.addStudent(name, age, course);
                    view.displayMessage("Student added successfully.");
                    break;
                case 2:
                    view.displayStudents(viewModel.getStudents());
                    break;
                case 3:
                    int id = view.getStudentId();
                    name = view.getStudentName();
                    age = view.getStudentAge();
                    course = view.getStudentCourse();
                    if (viewModel.updateStudent(id, name, age, course)) {
                        view.displayMessage("Student updated successfully.");
                    } else {
                        view.displayMessage("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
