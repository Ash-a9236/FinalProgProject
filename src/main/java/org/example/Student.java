package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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


    public Student(String studentId, String studentName, Gender gender, Address address, Department department,
                   ArrayList<Course> registeredCourses) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * adds the course to the student's registeredCourses list, adds the student to the course's registeredStudents
     * list, and appends a `null` for the `scores` of each assignment of the course
     * @param course the input course
     * @return if the course has been registered or not
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.println("You have already been registered");
            return false;
        }

        course.getStudents().add(this);
        registeredCourses.add(course);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        course.getFinalScores().add(null);
        System.out.printf("Added %s to your registered courses.%n", course.getCourseName());
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
            System.out.println("You already dropped this course");
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        System.out.println("Course dropped successfully.");
        return true;
    }

    public String toSimplifiedString2() {
        return "Student ID : " + studentId + ", Student Name : " + studentName + ", Department : " +
                department.getDepartmentName();
    }

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

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public Object getDepartment() {
        return department;
    }
}
