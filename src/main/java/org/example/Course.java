package org.example;
/*
- Fields

1. `String courseId` // `C-departmentId-twoDigitCourseId`, e.g.: `C-D01-01`
2. `String courseName`
3. `double credits`
4. `Department department`
5. `Assignment[]/ArrayList<Assignment> assignments`
6. `Student[]/ArrayList<Student> registeredStudents`
7. `double[]/ArrayList<Double> finalScores`
8. `static int nextId` // indicates the next ID that will be used

- Methods

1. `boolean isAssignmentWeightValid()` // checks if the sum of weights of all assignments of that
course equals to `1 (100%)`

2. `boolean registerStudent(Student student)` // adds a student to the student list of the course, also add a
new `null` element to each assignment of this course, and add a new `null` element for the `finalScores`.

3. `int[] calcStudentsAverage()` // calculates the weighted average score of a student.

4. `boolean addAssignment(String assignmentName, double weight, int maxScore)` // adds a new assignment to the course

5. `void generateScores()` // generates random scores for each assignment and student, and calculates the final score
for each student.

6. `void displayScores()` // displays the scores of a course in a table, with the assignment averages and
student weighted average

    ``` data
      example:
      Course: Programming 1(C-D00-01)
                        Assignment01   Assignment02   Assignment03         Exam01         Exam02    Final Score
              Yi Wang             82             82             76             85             80             82
              Yi Wang             97             92             84             67             90             83
              Yi Wang             91             68             82             83             83             82

              Average             90             81             81             78             84
    ```

7. `String toSimplifiedString()` // converts a course to a simple string with only the `courseId`,
`courseName`, `credits`, and `departmentName`.

8. `String toString()` // converts a course to a string that contains the `courseId`, the `courseName`, the credits,
the `departmentName` the `assignments`, and the `registeredStudents` (only the `studentId`,
the `studentName` and the `departmentName`)
*/
import java.util.ArrayList;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    @Getter
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    /**
     * checks if the sum of weights of all assignments of that course equals to 1 (100%)
     * @return if the sum is valid or not (if it is equal to 100%)
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0.0;
        for (Assignment assignment : assignments) {
            sum+= assignment.getWeight();
        }

        return Math.abs(sum - 1.0) < 0.001;
    }

    /**
     * adds a student to the student list of the course, and adds a new null element to each assignment of this course,
     * and add a new null element for the finalScore
     * @param student the input student
     * @return true if the course doesn't have the student already
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        finalScores.add(null);
        return true;
    }

    /**
     * Calculates the weighted average score of a student
     * @return the weighted average score the student
     */
    public int[] calcStudentsAverage() {
        int[] studentsAverage = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            double weightedSum = 0.0;
            int totalWeight = 0;

            for (int j = 0; j < assignments.size(); j++) {
                Assignment assignment = assignments.get(j);
                Integer score = assignment.getScores().get(i);

                if (score != null) {
                    weightedSum += (double) score * assignment.getWeight();
                    totalWeight += assignment.getWeight();
                }
            }

            if (totalWeight > 0) {
                studentsAverage[i] = (int) Math.round(weightedSum / totalWeight);
            } else {
                studentsAverage[i] = 0;
            }
        }

        return studentsAverage;
    }

    /**
     * Adds a new assignment to the course
     * @param assignmentName the input string
     * @param weight the input double
     * @param maxScore the input int
     * @return true if the assignment has been added
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment newAssignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(newAssignment);

        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }

        return true;
    }

    /**
     * Generates random scores for each assignment and student, and calculates the final score for each student
     */
    public void generateScores() {

    }

    public void setCourseName(String courseName) {
        this.courseName = Util.toTitleCase(courseName);
    }

    public String toSimplifiedString1() {
        return "CourseId: " + courseId +
                ", Course Name: " + courseName +
                ", Credits: " + credits +
                ", Department: " + department.getDepartmentName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course ID : ").append(courseId).append("\n");
        sb.append("Course Name : ").append(courseName).append("\n");
        sb.append("Credits : ").append(credits).append("\n");
        sb.append("Department : ").append(department.getDepartmentName()).append("\n");

        sb.append("Assignments :\n");
        for (Assignment assignment : assignments) {
            sb.append("\t").append(assignment.getAssignmentName()).append(", Weight : ").append(assignment.getWeight()).append("\n");
        }

        sb.append("Registered Students :\n");
        for (Student student : registeredStudents) {
            sb.append("\tStudent ID : ").append(student.getStudentId()).append(", Student Name : ")
                    .append(student.getStudentName()).append(", Department : ")
                    .append(student.getDepartment().getDepartmentName()).append("\n");
        }

        return sb.toString();
    }
}
