package org.dave;

import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Student> registeredStudents;
    private List<Assignment> assignments;

    private static int nextId = 1;
}
