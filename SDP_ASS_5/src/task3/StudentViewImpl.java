package task3;

import java.util.List;
import java.util.Scanner;

public class StudentViewImpl implements StudentView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayStudents(List<StudentModel> students) {
        System.out.println("Student Records:");
        for (StudentModel student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() +
                    ", Age: " + student.getAge() + ", Course: " + student.getCourse());
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getStudentName() {
        System.out.print("Enter student name: ");
        return scanner.nextLine();
    }

    @Override
    public int getStudentAge() {
        System.out.print("Enter student age: ");
        return scanner.nextInt();
    }

    @Override
    public String getStudentCourse() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter student course: ");
        return scanner.nextLine();
    }

    @Override
    public int getStudentId() {
        System.out.print("Enter student ID: ");
        return scanner.nextInt();
    }
}
