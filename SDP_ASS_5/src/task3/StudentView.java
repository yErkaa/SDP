package task3;

import java.util.List;

public interface StudentView {
    void displayStudents(List<StudentModel> students);
    void displayMessage(String message);
    String getStudentName();
    int getStudentAge();
    String getStudentCourse();
    int getStudentId();
}
