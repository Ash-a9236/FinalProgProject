import org.example.Assignment;
import org.example.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class AssignmentTest {
    @Test
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Exam 01", 0.4, 100, 3);

        assignment.getScores().add(0, 60);
        assignment.getScores().add(1, 60);
        assignment.getScores().add(2, 60);

        assignment.calcAssignmentAvg();

        double expectedResult = 60.0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Exam 01", 0.4, 100, 3);

        assignment.getScores().set(0, 45);
        assignment.getScores().set(1, 87);
        assignment.getScores().set(2, 95);

        assignment.calcAssignmentAvg();

        double expectedResult = 62.0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Exam 01", 0.4, 100, 3);

        assignment.calcAssignmentAvg();

        double expectedResult = Double.NaN;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg4() {
        Assignment assignment = new Assignment("Exam 01", 0.4, 100, 3);

        assignment.getScores().add(null);
        assignment.getScores().add(null);
        assignment.getScores().add(null);

        double expectedResult = 0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsTotalWeightValid1() {
        Course course = new Course("AABB001", "Algebra", 5, new
                Department("Computer Sciences"));
        course.addAssignment("Exam 01", 0.2, 100);
        course.addAssignment("Exam 02", 0.2, 100);
        course.addAssignment("Final Exam", 0.6, 100);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();
    }

    @Test
    public void testIsAssignmentsTotalWeightValid2() {
        Course course = new Course("AABB001", "Algebra", 5, new
                Department("Computer Sciences"));
        course.addAssignment("Exam 01", 0.1, 100);
        course.addAssignment("Final Exam", 0.6, 100);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();
    }

    @Test
    public void testIsAssignmentsTotalWeightValid4() {
        Course course = new Course("Programming1", "Algebra", 5, new
                Department("Computer Sciences"));

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();
    }
}
