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

    public enum Gender {
        MALE, FEMALE
    }

    /**
     * (1) adds the course to the student's registeredCourses list,
     * (2) adds the student to the course's registeredStudents list,
     * (3) appends a null for the scores of each assignment of the course
     * @param course the course to be registered
     * @return true if successfully registered the student, false the course is already registered
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        boolean registerStudentToCourse = course.registerStudent(this);

        if (!registerStudentToCourse) {
            return false;
        }

        registeredCourses.add(course);

        return true;
    }

    /**
     * Removes the course from the student's registeredCourses list,
     * and remove the student from the course's registeredStudents list.
     * If the course not in the student's registeredCourses list
     * directly returns false without removing anything.
     * @param course the course to be registered to
     * @return true if registered successfully, false if the course not in the student's registeredCourses
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);

        course.getRegisteredStudents().remove(this);

        return true;
    }

    public String toSimplifiedString() {
        return "studentId = " + studentId  +
                ", studentName = " + studentName +
                ", department = " + department +
                '}';
    }

    @Override
    public String toString() {
        String str = "Student{" +
                "studentId = " + studentId +
                ", studentName = " + studentName +
                ", gender = " + gender +
                ", address = " + address.getStreetNo() +
                " " + address.getStreet() +
                " " + address.getCity() +
                " " + address.getProvince() +
                " " + address.getPostalCode() +
                ", department = " + department.getDepartmentName() +
                ", courses = [";

        for (int i = 0; i < registeredCourses.size(); i++) {
            Course course = registeredCourses.get(i);
            str += course.toSimplifiedString();

            if (i < registeredCourses.size() - 1) {
                str += ", ";
            }
        }

        str += "]}";

        return str;
    }
}
