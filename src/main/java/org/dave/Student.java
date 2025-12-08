package org.dave;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * (1) adds the course to the student's registeredCourses list,
     * (2) adds the student to the course's registeredStudents list,
     * (3) appends a null for the scores of each assignment of the course
     * @param course the course to be registered
     * @return true if successfully registered the student, false the course is already registered
     */
    public boolean registerCourse(Course course) {
        if  (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);

        course.registerStudent(this);

        return true;
    }

    public enum Gender {
        MALE, FEMALE
    }

}
