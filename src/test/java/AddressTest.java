import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    public void testIsPostalCodeValid1() {
        String str = "H3X3R7";

        Assertions.assertTrue(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid2() {
        String str = "H3X 3R7";

        Assertions.assertTrue(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid3() {
        String str = "h3x3r7";

        Assertions.assertTrue(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid4() {
        String str = "h3x 3r7";

        Assertions.assertTrue(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid5() {
        String str = "null";

        Assertions.assertFalse(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid6() {
        String str = "";

        Assertions.assertFalse(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid7() {
        String str = "H3X=3R7";

        Assertions.assertFalse(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid8() {
        String str = "h3x=3r7";

        Assertions.assertFalse(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid9() {
        String str = "H3X3R";

        Assertions.assertFalse(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid10() {
        String str = "H3X 3R";

        Assertions.assertFalse(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid11() {
        String str = "123456";

        Assertions.assertFalse(Address.isPostalCodeValid(str));
    }

    @Test
    public void testIsPostalCodeValid12() {
        String str = "abcdef";

        Assertions.assertFalse(Address.isPostalCodeValid(str));
    }
}
