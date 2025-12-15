import org.dave.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    @DisplayName("null -> false")
    void testIsPostalCodeValid1() {
        String input = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("A1B2C3 -> true")
    void testIsPostalCodeValid2() {
        String input = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" ' ' -> false")
    void testIsPostalCodeValid3() {
        String input = "";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("A1B2C -> false")
    void testIsPostalCodeValid4() {
        String input = "A1B2C";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("A1B2C3D -> false")
    void testIsPostalCodeValid5() {
        String input = "A1B2C3D";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("123456 -> false")
    void testIsPostalCodeValid6() {
        String input = "123456";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ABCDEF -> false")
    void testIsPostalCodeValid7() {
        String input = "ABCDEF";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("A12B3C -> false (wrong letter-digit pattern)")
    void testIsPostalCodeValid8() {
        String input = "A12B3C";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("A1B2C! -> false (invalid character)")
    void testIsPostalCodeValid9() {
        String input = "A1B2C!";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("a1b2c3 -> true")
    void testIsPostalCode10() {
        String input = "a1b2c3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }
}

