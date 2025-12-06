package org.dave;

public class Department {
    private String departmentName;
    private String departmentId;
    private static int nextId = 0;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentId = String.format("%05d", nextId++);
    }
}
