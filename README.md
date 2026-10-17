# Academic Management CLI

[![Build](https://github.com/JaunteGarciaZa/JavaStudentGradeCalculator/actions/workflows/build.yml/badge.svg)](https://github.com/JaunteGarciaZa/JavaStudentGradeCalculator/actions/workflows/build.yml)

A console app that registers students, validates their marks and prints a class report. It is small, but built the way bigger programs are: a clear domain model, rules behind an interface, and input handling that doesn't fall over.

```
====================================
   ACADEMIC MANAGEMENT SYSTEM v2.0
====================================

[MENU]
1. Register Student & Calculate Average
2. View Full Class Report
3. Exit System
Selection >
```

A class report, straight from the CI smoke test:

```
==============================
CLASS REPORT
LECTURER: Lecturer: Jane Doe | Contact: j.doe@uni.edu | Expert in: [Software Engineering]
==============================
--------------------------------
| STUDENT RECORD
--------------------------------
| Name:    Ada Lovelace
| Email:   ada.lovelace@student.com
| Average: 80%
| Subjects: [Maths, Science]
--------------------------------
```

And what a mark of 150 gets you, with the menu still running:

```
Grade (0-100): 150
Validation Error: Grades must be between 0 and 100.
```

## What it does

- **Registers a student:** first name and surname, then any number of subjects with a mark for each. It generates a student email and reports the student's average and performance band.
- **Bands performance:** 75 and above is a **Distinction**, 50 and above is a **Pass**, anything lower is a **Fail**.
- **Prints a class report:** the lecturer, then a formatted record for every enrolled student.
- **Survives bad input:** typing text where a number belongs, or a mark outside 0–100, gets a clear message and the menu keeps running instead of crashing.

## Design

| Class | Role |
|---|---|
| `GradeCalculator` | Interface defining the grading rules: `calculateAverage` and `determinePerformance` |
| `App` | Implements the interface; runs the menu loop and handles input |
| `Student` | Name, contact details, subjects, marks and average |
| `Lecturer` | The class's lecturer and the subjects they teach |
| `SchoolClass` | A lecturer and the students enrolled with them |

Averages are computed with streams (`mapToInt(...).average()`). Menu choices use switch expressions, and the program starts from an instance `main` method, a standard feature since Java 25.

## Run it

You need **JDK 25**. Every push is compiled and smoke-tested by GitHub Actions: it registers a student, prints the report and checks that a bad mark is rejected.

```bash
cd GradeCalculator
javac -d out src/GradeCalculator/App.java src/GradeCalculator/Util/*.java
java -cp out GradeCalculator.App
```

Or open the `GradeCalculator` folder in IntelliJ IDEA and run `App`.

## Built with

Java 25 · object-oriented design · interfaces · streams

---

Part of my portfolio: [jauntegarciaza.github.io](https://jauntegarciaza.github.io/)
