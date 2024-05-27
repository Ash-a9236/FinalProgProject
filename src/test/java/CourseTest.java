import org.example.Address;
import org.example.Course;
import org.example.Gender;
import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CourseTest {
    @Test
    public void testCalcStudentAvg1() {
        Student student = new Student("Jared", Gender.MALE, new Address(5, "-", "-",
                "-", "h3x3r7", "-"), "Com", "Computer Science", "");


        Course course = new Course("CST", "Programming 1", "3", "Computer Science";
        student.registerCourse(course);
        student2.registerCourse(course);
        student3.registerCourse(course);
        course.addAssignment("Exam1", 0.2, 100);
        course.addAssignment("Exam2", 0.2, 100);
        course.addAssignment("FinalExam", 0.6, 100);

        course.getAssignments().get(0).getScores().set(0, 80);
        course.getAssignments().get(1).getScores().set(0, 80);
        course.getAssignments().get(2).getScores().set(0, 80);

        course.getAssignments().get(0).getScores().set(1, 80);
        course.getAssignments().get(1).getScores().set(1, 80);
        course.getAssignments().get(2).getScores().set(1, 80);

        course.getAssignments().get(0).getScores().set(2, 80);
        course.getAssignments().get(1).getScores().set(2, 80);
        course.getAssignments().get(2).getScores().set(2, 80);

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(80.0);
        expectedResult.add(80.0);
        expectedResult.add(80.0);
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg2() {
        Student student = new Student("Dog", Gender.MALE, new Address(5, "x", "x", "x", "x", "H8N 3B3"), new Department("CST"));
        Student student2 = new Student("Cat", Gender.FEMALE, new Address(5, "x", "x", "x", "x", "H8N 3B3"), new Department("CST"));
        Student student3 = new Student("Bird", Gender.FEMALE, new Address(5, "x", "x", "x", "x", "H8N 3B3"), new Department("CST"));
        Course course = new Course("Programming1", 4, new Department("CST"));
        student.registerCourse(course);
        student2.registerCourse(course);
        student3.registerCourse(course);
        course.addAssignment("Exam1", 0.2, 100);
        course.addAssignment("Exam2", 0.2, 100);
        course.addAssignment("FinalExam", 0.6, 100);

        course.getAssignments().get(0).getScores().set(0, 40);
        course.getAssignments().get(1).getScores().set(0, 80);
        course.getAssignments().get(2).getScores().set(0, 90);

        course.getAssignments().get(0).getScores().set(1, 85);
        course.getAssignments().get(1).getScores().set(1, 75);
        course.getAssignments().get(2).getScores().set(1, 55);

        course.getAssignments().get(0).getScores().set(2, 80);
        course.getAssignments().get(1).getScores().set(2, 90);
        course.getAssignments().get(2).getScores().set(2, 100);

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(78.0);
        expectedResult.add(65.0);
        expectedResult.add(94.0);
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg3() {
        Student student = new Student("Dog", Gender.MALE, new Address(5, "x", "x", "x", "x", "H8N 3B3"), new Department("CST"));
        Course course = new Course("Programming1", 4, new Department("CST"));
        student.registerCourse(course);
        course.addAssignment("Exam1", 0.2, 100);
        course.addAssignment("Exam2", 0.2, 100);
        course.addAssignment("FinalExam", 0.6, 100);

        course.getAssignments().get(0).getScores().set(0, 40);
        course.getAssignments().get(1).getScores().set(0, 80);
        course.getAssignments().get(2).getScores().set(0, 90);

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(78.0);
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg4() {
        Course course = new Course("Programming1", 4, new Department("CST"));

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }
}