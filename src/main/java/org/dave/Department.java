package org.dave;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class Department {
    private String departmentName;
    private String departmentId;
    private static int nextId = 0;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentId = String.format("%05d", nextId++);
    }

    /**
     * Checks if the department name is valid or invalid
     * @param departmentName the given department name
     * @return true if department name is valid, false if department name is invalid
     */
    public boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null) {
            return false;
        }

        if (departmentName.isBlank()) {
            return false;
        }

        for (char  c : departmentName.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
