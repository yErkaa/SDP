package task3;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel {
    private final List<StudentModel> students = new ArrayList<>();
    private int nextId = 1;

    public List<StudentModel> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(String name, int age, String course) {
        StudentModel student = new StudentModel(nextId++, name, age, course);
        students.add(student);
    }

    public boolean updateStudent(int id, String name, int age, String course) {
        for (StudentModel student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                return true;
            }
        }
        return false;
    }
}
