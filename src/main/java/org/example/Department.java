package org.example;
/*
- Fields

1. `String departmentId` // 2-digits starts with a character `D`
2. `String departmentName`
3. `static int nextId` // indicates the next ID that will be used

- Methods

1. `static boolean validateDepartmentName(String departmentName)` // checks if a department name is valid or not, a
department name should only contain letters or space
2. Constructor // if the `departmentName` is invalid, create the object with everything as `null`;
3. toString
4. equals
5. getter
6. setter
 */
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
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = "D" + nextId++;
            this.departmentName = departmentName;
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
}
