package org.dave;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Student> registeredStudents;
    private List<Assignment> assignments;

    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.registeredStudents = new ArrayList<>(20);
        this.assignments = new ArrayList<>(10);
    }

    /**
     * Checks if the sum of weights of all assignments of the course is equals to 100%
     * @return true if valid, false if invalid
     */
    public boolean isAssignmentWeightValid() {
        int sum = 0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return sum == 100;
    }

    /**
     * Adds a student to the student list of the course,
     * also add a new null element to each assignment of this course,
     * and add a new null element for the finalScores.
     * @param student the student to be added
     * @return true if successfully added student to the list,
     * false if the student is already in the list
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }
}
