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
        Student student = new Student("J", Gender.MALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));
        Student student1 = new Student("F", Gender.MALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));
        Student student2 = new Student("K", Gender.FEMALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));

        Course course = new Course("AABB001", "Algebra", 4, new Department("CST"));
        student.registerCourse(course);
        student2.registerCourse(course);

        course.addAssignment("Exam 01", 0.4, 100);
        course.addAssignment("Exam 02", 0.2, 100);
        course.addAssignment("Final Exam", 0.6, 100);

        course.getAssignments().get(0).getScores().set(0, 60);
        course.getAssignments().get(1).getScores().set(0, 60);
        course.getAssignments().get(2).getScores().set(0, 60);

        course.getAssignments().get(0).getScores().set(1, 60);
        course.getAssignments().get(1).getScores().set(1, 60);
        course.getAssignments().get(2).getScores().set(1, 60);

        course.getAssignments().get(0).getScores().set(2, 60);
        course.getAssignments().get(1).getScores().set(2, 60);
        course.getAssignments().get(2).getScores().set(2, 60);

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(60.0);
        expectedResult.add(60.0);
        expectedResult.add(60.0);
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg2() {
        Student student = new Student("J", Gender.MALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));
        Student student1 = new Student("F", Gender.MALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));
        Student student2 = new Student("K", Gender.FEMALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));

        Course course = new Course("AABB001", "Algebra", 4, new Department("CST"));
        student.registerCourse(course);
        student2.registerCourse(course);

        course.addAssignment("Exam 01", 0.4, 100);
        course.addAssignment("Exam 02", 0.2, 100);
        course.addAssignment("Final Exam", 0.6, 100);

        course.getAssignments().get(0).getScores().set(0, 50);
        course.getAssignments().get(1).getScores().set(0, 80);
        course.getAssignments().get(2).getScores().set(0, 60);

        course.getAssignments().get(0).getScores().set(1, 85);
        course.getAssignments().get(1).getScores().set(1, 85);
        course.getAssignments().get(2).getScores().set(1, 77);

        course.getAssignments().get(0).getScores().set(2, 80);
        course.getAssignments().get(1).getScores().set(2, 70);
        course.getAssignments().get(2).getScores().set(2, 100);

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(63.333333);
        expectedResult.add(82.333333);
        expectedResult.add(83.333333);
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg3() {
        Student student = new Student("J", Gender.MALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));
        Student student1 = new Student("F", Gender.MALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));
        Student student2 = new Student("K", Gender.FEMALE, new Address(5, "-", "-",
                "-", "h3x4r6", "-"), new Department("History"));

        Course course = new Course("AABB001", "Algebra", 4, new Department("CST"));
        student.registerCourse(course);
        student2.registerCourse(course);

        course.addAssignment("Exam 01", 0.4, 100);
        course.addAssignment("Exam 02", 0.2, 100);
        course.addAssignment("Final Exam", 0.6, 100);

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
        Course course = new Course("AABB001", "Algebra", 4, new Department("CST"));

        course.calcStudentsAverage();

        ArrayList<Double> expectedResult = new ArrayList<>();
        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }
}