package GradeCalculator.Util;

import java.util.ArrayList;

public class Lecturer {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private ArrayList<String> subjects;

    public Lecturer(String name, String surname, String email, String phone, ArrayList<String> subjects) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return String.format(
                "Lecturer: %s %s | Contact: %s | Expert in: %s",
                name, surname, email, subjects.toString()
        );
    }




}