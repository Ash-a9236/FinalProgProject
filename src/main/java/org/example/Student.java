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
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private Course[] registeredCourses;
    private static int nextId;
}
