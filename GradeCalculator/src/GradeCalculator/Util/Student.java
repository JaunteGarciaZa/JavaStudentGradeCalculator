package GradeCalculator.Util;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int gradeAvg;
    private ArrayList<String> subjects;
    private ArrayList<Integer> grades;

    public Student(String name, String surname, String email, String phone, int gradeAvg, ArrayList<String> subjects, ArrayList<Integer> grades) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.gradeAvg = gradeAvg;
        this.subjects = subjects;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return String.format(
                "--------------------------------\n" +
                        "| STUDENT RECORD\n" +
                        "--------------------------------\n" +
                        "| Name:    %s %s\n" +
                        "| Email:   %s\n" +
                        "| Average: %d%%\n" +
                        "| Subjects: %s\n" +
                        "--------------------------------",
                name, surname, email, gradeAvg, subjects.toString()
        );
    }
}