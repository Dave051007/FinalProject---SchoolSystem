package org.dave;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    @Setter double credits;
    @Setter private Department department;
    @Setter private List<Student> registeredStudents;
    @Setter private List<Assignment> assignments;
    @Setter private List<Integer> finalScores;

    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.registeredStudents = new ArrayList<>(20);
        this.assignments = new ArrayList<>(10);
        this.finalScores = new ArrayList<>(20);
    }

    /**
     * Checks if the sum of weights of all assignments of the course is equals to 100%
     * @return true if valid, false if invalid
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return Math.round(sum) == 100;
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

        finalScores.add(null);

        return true;
    }

    /**
     * Calculates the weighted average score of a student.
     * @return an array of weighted average score of each student.
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    sum += score;
                }
            }

            averages[i] = (int) Math.round(sum / assignments.size());
        }

        return averages;
    }

    /**
     * Adds an assignment to the course.
     * @param assignmentName the assignment to be added
     * @param weight the weight of the assignment
     * @return true when task done successfully
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment newAssignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }

        assignments.add(newAssignment);

        return true;
    }

    /**
     *  Generates random scores for each assignment and student,
     *  and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    sum += score * (assignment.getWeight() / 100.0);
                }
            }

            int finalScore = (int) Math.round(sum);

            finalScores.set(i, finalScore);
        }
    }

    /**
     * Displays the scores of a course in a table,
     * with the assignment averages and student weighted average
     */
    public void displayScores() {
        System.out.printf("Course: %s (%s)%n", courseName, courseId);

        System.out.print("                ");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s", assignment.getAssignmentName());
        }

        System.out.println("Weighted Average Score");

        int[] studentAverages = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%-20s", student.getStudentName());
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.printf("%-15s", score != null ? score : "-");
            }

            System.out.println(studentAverages[i]);
        }

        System.out.printf("%-20s", "Average");
        for (Assignment a : assignments) {
            double sum = 0;

            for (Integer score : a.getScores()) {
                    sum += score;
            }

            double avg = sum / a.getScores().size();
            System.out.printf("%-15.0f", avg);
        }

        System.out.println();
    }

    public String toSimplifiedString() {
        return "{courseId = " + courseId +
                ", courseName = " + courseName +
                ", department = " + department.getDepartmentName() +
                ", credits = " + credits +
                '}';
    }

    @Override
    public String toString() {
        String str = "Course{" +
                "courseId = " + courseId +
                ", courseName = " + courseName +
                ", credits = " + credits +
                ", department = " + department +
                ", registeredStudents = [";

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            str += student.toSimplifiedString();

            if (i < registeredStudents.size() - 1) {
                str += ", ";
            }
        }

        str += "]}";

        return str;
    }

    public void setCourseName(String courseName) {
        courseName = Util.toTitleCase(courseName);
        this.courseName = courseName;
    }
}
