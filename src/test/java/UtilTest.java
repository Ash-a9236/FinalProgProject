import org.example.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    public void testToTitleCase1() {
        String str = "hello world";
        String expectedResult = "Hello World";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase2() {
        String str = "Hello world";
        String expectedResult = "Hello World";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase3() {
        String str = "hELLO wORLD";
        String expectedResult = "Hello World";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase4() {
        String str = "hEllO wOrlD";
        String expectedResult = "Hello World";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase5() {
        String str = null;
        String expectedResult = null;
        String result = null;

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase6() {
        String str = "";
        String expectedResult = "null";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }
}
