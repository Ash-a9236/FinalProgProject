package org.example;
/*
- Fields

1. `String studentId` // 6-digits starts with a character `S`
2. `String studentName`
3. `Gender gender`
4. `Address address`
5. `Department department`
6. `Course[]/ArrayList<Course> registeredCourses`
7. `static int nextId` // indicates the next ID that will be used

- Methods

1. `boolean registerCourse(Course course)` // registers a course, this method
    (1) adds the course to the student's registeredCourses list,
    (2) adds the student to the course's registeredStudents list,
    (3) appends a `null` for the `scores` of each assignment of the course. If the course is already registered,
    directly returns `false`

2. `boolean dropCourse(Course course)` // drops a course, remove the course from the student's registeredCourses list,
and remove the student from the course's registeredStudents list. If the course is not registered yet,
directly returns `false`

3. Constructor with `studentName`, `gender`, `address`, and `department`, it will create a student
with `studentId` automatically generated based on the `nextId`, and `registeredCourses` as empty object

4. `toSimplifiedString` // converts a student to a simple string with only the `studentId`, the `studentName`,
and `departmentName`. This method is called in `Course` `toString()`.

5. `toString` // converts a student to a string that contains the `studentId`, the `studentName`,
the `gender`, the `address` and the `department`, and the `registeredCourses`
(only the `courseId`, the `courseName`, and the `departmentName`)

6. equals
7. getters
8. setters
 */

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;


/*______________________________________________________________________________________________________________________
3.
Constructor with `studentName`, `gender`, `address`, and `department`, it will create a student
with `studentId` automatically generated based on the `nextId`, and `registeredCourses` as empty object
 */

    public Student(String studentId, String studentName, Gender gender, Address address, Department department,
                   ArrayList<Course> registeredCourses) {
        this.studentId = "S" + nextId++;
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }


/*______________________________________________________________________________________________________________________
1.
`boolean registerCourse(Course course)` // registers a course, this method
    (1) adds the course to the student's registeredCourses list,
    (2) adds the student to the course's registeredStudents list,
    (3) appends a `null` for the `scores` of each assignment of the course. If the course is already registered,
    directly returns `false`
 */

    /**
     * adds the course to the student's registeredCourses list, adds the student to the course's registeredStudents
     * list, and appends a `null` for the `scores` of each assignment of the course
     * @param course the input course
     * @return if the course has been registered or not
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }


/*______________________________________________________________________________________________________________________
2.
`boolean dropCourse(Course course)` // drops a course, remove the course from the student's registeredCourses list,
and remove the student from the course's registeredStudents list. If the course is not registered yet,
directly returns `false`

 */

    /**
     * drops a course, remove the course from the student's registeredCourses list and remove the student from the
     * course's registeredStudents list
     * @param course the input course
     * @return if the course has been successfully dropped or not
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }


/*______________________________________________________________________________________________________________________
4. `toSimplifiedString`
// converts a student to a simple string with only the `studentId`, the `studentName`,
and `departmentName`. This method is called in `Course` `toString()`.
 */
    public String toSimplifiedString2() {
        return "Student ID : " + studentId + ", Student Name : " + studentName + ", Department : " +
                department.getDepartmentName();
    }

/*______________________________________________________________________________________________________________________
5. `toString`
// converts a student to a string that contains the `studentId`, the `studentName`,
the `gender`, the `address` and the `department`, and the `registeredCourses`
(only the `courseId`, the `courseName`, and the `departmentName`)
 */

    @Override
    public String toString() {
        return String.format("Student : " +
                "\nStudent ID : " + studentId +
                "\nStudent Name : " + studentName +
                "\nGender : " + gender +
                "\nAddress : " + address +
                "\nDepartment : " + department +
                "\nRegistered Courses : " + registeredCourses);
    }
/*
________________________________________________________________________________________________________________________
 */
    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public org.example.Department getDepartment() {
        return department;
    }
}
