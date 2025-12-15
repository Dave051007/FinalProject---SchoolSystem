# Final Project - School System

## Author: Lauren Dave Fermin
## ID: 6375254

---

## Overview
This is the final project for the Introduction to Programming course at Vanier.
This project demonstrates the use object-oriented programming.

---

## Code Description
The SchoolSystem is a Java program that lets you manage students, courses, departments, and assignments.
It allows you register students, drop a student from a course, add assignments, generate scores, and calculate averages. 

---

## Methods
### Student
- `registerCourse(Course course)` – Register the student in a course.
- `dropCourse(Course course)` – Remove the student from a course.

### Course
- `registerStudent(Student student)` – Add a student to the course and initialize scores.
- `addAssignment(String assignmentName, double weight)` – Add a new assignment.
- `isAssignmentWeightValid()` – Verify that all assignment weights sum to 100%.
- `generateScores()` – Generate random scores and calculate final scores.
- `calcStudentsAverage()` – Calculate weighted averages for each student.
- `displayScores()` – Print the course scores in a table.

### Assignment
- `generateRandomScore()` – Generate random scores for all students.
- `calcAssignmentAvg()` – Calculate the average score of the assignment.

### Department & Address
- Validate names and postal codes.
- Automatically generate IDs.

### Util
- `toTitleCase(String str)` – Convert strings to title case -> Xxxxx

---

## Features
- Automatic ID generation for students, courses, and departments
- Weighted assignment grading
- Random score generation
- Tabular display of student scores and assignment averages
- Input validation for postal codes, department names, and assignment weights
- Consistent formatting for names using title case

---

## Dependencies
- **JUnit Jupiter** – for unit testing user-defined methods
- **Lombok** – for automatic getters, setters, `toString()`, and `equals()`

---

## Example Usage
```java
        // Department name
        Department d1 = new Department("Vanier");

        // Courses available
        Course c1 = new Course("Java", 3, d1);

        // Students in Vanier department
        Student s1 = new Student("bOb", Student.Gender.MALE, new Address(101, "Rue St. Paul", "Montreal", Address.Province.QC, "h1h1h1"), d1);
        Student s2 = new Student("aNDREw", Student.Gender.MALE, new Address(101, "Berri", "Montreal", Address.Province.QC, "a2a2a2"), d1);
        Student s3 = new Student("AMELIA", Student.Gender.FEMALE, new Address(101, "Bourret Ave.", "Montreal", Address.Province.QC, "k3k3k3"), d1);

        // Register students to the Java course
        s1.registerCourse(c1);
        s2.registerCourse(c1);
        s3.registerCourse(c1);

        // Assignments and their weight
       c1.addAssignment("Code1", 20);
       c1.addAssignment("Code2", 20);
       c1.addAssignment("Code3", 20);
       c1.addAssignment("Code4", 20);
       c1.addAssignment("Code5", 20);

       // Checks if assignment weights adds up to 100
        System.out.println(c1.isAssignmentWeightValid());

        // Generate random scores for each student
       c1.generateScores();

       // Displays the weighted average scores of each student and the assignments average in a table
       c1.displayScores();

       // Prints out information about course
       System.out.print(c1);

       // Prints out information about student
        System.out.println(s1);