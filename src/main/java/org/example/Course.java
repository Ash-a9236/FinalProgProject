package org.example;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

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
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;


    public Course(String departmentId, String courseName, double credits, Department department) {
        this.courseId = String.format("C-D%02d-%02d", nextId, nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * checks if the sum of weights of all assignments of that course equals to 1 (100%)
     * @return if the sum is valid or not (if it is equal to 100%)
     */
    public boolean isAssignmentWeightValid() {
        if (assignments == null || assignments.isEmpty()) {
            return false;
        }

        double sum = 0.0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return (sum == 1.0);
    }

    /**
     * adds a student to the student list of the course, and adds a new null element to each assignment of this course,
     * and add a new null element for the finalScore
     * @param student the input student
     * @return true if the course doesn't have the student already
     */
    public boolean registerStudent(Student student) {
        for (Student registeredStudent : registeredStudents) {
            if (registeredStudent.equals(student)) {
                System.out.println("The student has already been registered");
                return false;
            }
        }

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        registeredStudents.add(student);
        finalScores.add(null);
        return true;
    }

    /**
     * Calculates the weighted average score of a student
     * @return the weighted average score the student
     */
    public int[] calcStudentsAverage() {
        if (assignments == null || registeredStudents == null) {
            System.out.println("null");
        }

        int[] studentsAverage = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {

            double average = 0.0;

            for (Assignment assignment : assignments) {
                average += assignment.getScores().get(i) * assignment.getWeight();
            }

            finalScores.set(i, average);
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
        for (Assignment existingAssignment : assignments) {
            if (existingAssignment.getAssignmentName().equals(assignmentName)) {
                System.out.println("Assignment already in system");
                return false;
            }
        }

        Assignment newAssignment = new Assignment(assignmentName, weight, maxScore, registeredStudents.size());
        assignments.add(newAssignment);
        System.out.println("Assignment created");
        return true;
    }

    /**
     * Generates random scores for each assignment and student, and calculates the final score for each student
     */
    public void generateScores() {
        Random random = new Random();

        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        calculateFinalScores();
    }

    /**
     * calculates the final score of a student
     */
    private void calculateFinalScores() {
        for (int i = 0; i < registeredStudents.size(); i++) {
            double totalWeightedScores = 0;

            for (Assignment assignment : assignments) {
                int score = assignment.getScores().get(i);
                if (score >= 0) {
                    totalWeightedScores += score * assignment.getWeight();
                }
            }
            Double set = finalScores.set(i, totalWeightedScores);
        }
    }



    public void displayScores() {
        System.out.printf("%nCourse : %s(%s)%n", courseName, courseId);

        System.out.printf("%-20s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s", assignment.getAssignmentName());
        }
        System.out.printf("%-15s%n", "Final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%-20s", student.getStudentName());
            for (Assignment assignment : assignments) {
                int score = assignment.getScores().get(i);
                PrintStream printf = System.out.printf("%-15s", (score >= 0) ? score : "null");
            }
            System.out.printf("%-15s%n", finalScores.get(i).intValue());
        }

        System.out.printf("%-20s", "Average");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s", assignment.getAssignmentAverage());
        }
        System.out.println();

    }

    public String toSimplifiedString1() {
        return String.format("Course ID : " + courseId +
                "\nCourse Name : " + courseName +
                "\nCredits : " + credits +
                "\nDepartment : " + department.getDepartmentName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course ID : ").append(courseId).append("\n");
        sb.append("Course Name : ").append(courseName).append("\n");
        sb.append("Credits : ").append(credits).append("\n");
        sb.append("Department : ").append(department.getDepartmentName()).append("\n");

        sb.append("Assignments :\n");
        for (Assignment assignment : assignments) {
            sb.append("\t").append(assignment.getAssignmentName()).append(", Weight : ")
                    .append(assignment.getWeight()).append("\n");
        }

        sb.append("Registered Students :\n");
        for (Student student : registeredStudents) {
            sb.append("\tStudent ID : ").append(student.getStudentId()).append(", Student Name : ")
                    .append(student.getStudentName()).append(", Department : ")
                    .append(student.getDepartment()).append("\n");
        }

        return sb.toString();
    }

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public Calendar getFinalScores() {
    }

    public Object getCourseName() {
    }

    public Calendar getStudents() {
    }
}
