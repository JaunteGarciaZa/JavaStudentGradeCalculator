package GradeCalculator;

import GradeCalculator.Util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App implements GradeCalculator {
    private final Scanner scanner = new Scanner(System.in);
    private SchoolClass currentClass;
    private boolean isRunning = true;

    void main() {
        new App().run();
    }

    void run() {
        setupInitialData();
        System.out.println("====================================");
        System.out.println("   ACADEMIC MANAGEMENT SYSTEM v2.0  ");
        System.out.println("====================================");

        while (isRunning) {
            displayMenu();
            handleMenuChoice();
        }
    }

    private void setupInitialData() {
        Lecturer lead = new Lecturer("Jane", "Doe", "j.doe@uni.edu", "555-123",
                new ArrayList<>(List.of("Software Engineering")));
        currentClass = new SchoolClass(lead);
    }

    private void displayMenu() {
        System.out.println("\n[MENU]");
        System.out.println("1. Register Student & Calculate Average");
        System.out.println("2. View Full Class Report");
        System.out.println("3. Exit System");
        System.out.print("Selection > ");
    }

    private void handleMenuChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addNewStudent();
                case 2 -> displayClassReport();
                case 3 -> isRunning = false;
                default -> System.out.println("Please select a valid option (1-3).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please enter a number, not text.");
        }
    }

    private void addNewStudent() {
        try {
            System.out.println("\n-- New Student Registration --");
            System.out.print("First Name: ");
            String name = scanner.nextLine();
            System.out.print("Surname: ");
            String surname = scanner.nextLine();

            ArrayList<String> subjects = new ArrayList<>();
            ArrayList<Integer> grades = new ArrayList<>();

            System.out.print("Number of subjects: ");
            int count = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < count; i++) {
                System.out.print("Subject name: ");
                subjects.add(scanner.nextLine());

                System.out.print("Grade (0-100): ");
                int grade = Integer.parseInt(scanner.nextLine());

                if (grade < 0 || grade > 100) throw new IllegalArgumentException("Grades must be between 0 and 100.");
                grades.add(grade);
            }

            int avg = (int) calculateAverage(grades);

            Student s = new Student(name, surname, (name + "." + surname + "@student.com").toLowerCase(),
                    "N/A", avg, subjects, grades);

            currentClass.addStudent(s);
            System.out.println("\nStudent Added Successfully!");
            System.out.println("Performance Category: " + determinePerformance(avg));

        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
    }

    private void displayClassReport() {
        System.out.println("\n" + "=".repeat(30));
        System.out.println("CLASS REPORT");
        System.out.println("LECTURER: " + currentClass.getLecturer().toString());
        System.out.println("=".repeat(30));

        if (currentClass.getStudents().isEmpty()) {
            System.out.println("No students enrolled in this class.");
        } else {
            for (Student s : currentClass.getStudents()) {
                System.out.println(s.toString());
            }
        }
    }

    @Override
    public double calculateAverage(ArrayList<Integer> grades) {
        if (grades == null || grades.isEmpty()) return 0.0;
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public String determinePerformance(double average) {
        if (average >= 75) return "Distinction";
        if (average >= 50) return "Pass";
        return "Fail";
    }
}