package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Department {
    private String departmentId;
    @Getter private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * checks if a department name is valid or not, if the department name only contain letters or space
     * @param departmentName the input department name
     * @return if the department is valid or not
     */
    public static boolean validateDepartmentName(String departmentName) {

        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        return departmentName.matches("[a-zA-Z_0-9]");
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }
}
