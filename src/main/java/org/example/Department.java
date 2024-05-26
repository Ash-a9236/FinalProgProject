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
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId;

    /**
     * checks if a department name is valid or not, if the department name only contain letters or space
     * @param departmentName the input department name
     * @return if the department is valid or not
     */
    public static boolean validateDepartmentName(String departmentName) {
        boolean isValid = false;

        if (departmentName == null || departmentName.isEmpty()) {
            return isValid;
        }

        if (departmentName.matches("[a-zA-Z_0-9]")) {
            isValid = true;
        }
        return isValid;
    }
}
