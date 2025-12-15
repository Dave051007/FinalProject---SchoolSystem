import org.dave.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    @DisplayName("normal sentence -> title case")
    void testToTitleCase1() {
        String input = "hello world";
        String expected = "Hello World";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("single word -> title case")
    void testToTitleCase2() {
        String input = "java";
        String expected = "Java";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("mixed case input -> title case")
    void testToTitleCase3() {
        String input = "hElLo WoRLD";
        String expected = "Hello World";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("empty string -> empty string")
    void testToTitleCase4() {
        String input = "";
        String expected = "";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null input -> null")
    void testToTitleCase5() {
        String input = null;
        String expected = null;
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("string with multiple spaces -> trimmed title case")
    void testToTitleCase6() {
        String input = "   hello    world  java ";
        String expected = "Hello World Java";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("string with all uppercase -> title case")
    void testToTitleCase7() {
        String input = "HELLO WORLD";
        String expected = "Hello World";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("string with numbers -> numbers remain unchanged")
    void testToTitleCase8() {
        String input = "java 101 tutorial";
        String expected = "Java 101 Tutorial";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("string with special characters -> letters title case, others unchanged")
    void testToTitleCase9() {
        String input = "hello-world java_program";
        String expected = "Hello-world Java_program";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }
}
