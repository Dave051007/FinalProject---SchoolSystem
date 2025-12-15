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

