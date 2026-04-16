package GradeCalculator.Util;

import java.util.ArrayList;

public class SchoolClass { // Renamed from Class
    private Lecturer lecturer;
    private ArrayList<Student> students = new ArrayList<>();

    public SchoolClass(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void addStudent(Student s) { students.add(s); }
    public ArrayList<Student> getStudents() { return students; }
    public Lecturer getLecturer() { return lecturer; }
}