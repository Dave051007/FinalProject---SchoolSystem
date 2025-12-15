import org.dave.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    @Test
    @DisplayName("valid department name -> true")
    void testIsDepartmentNameValid1() {
        String input = "Computer Science";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> false")
    void testIsDepartmentNameValid2() {
        String input = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("empty string -> false")
    void testIsDepartmentNameValid3() {
        String input = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("blank string -> false")
    void testIsDepartmentNameValid4() {
        String input = "   ";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("contains digits -> false")
    void testIsDepartmentNameValid5() {
        String input = "Math101";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("contains special characters -> false")
    void testIsDepartmentNameValid6() {
        String input = "Comp@Sci!";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("valid name with spaces -> true")
    void testIsDepartmentNameValid7() {
        String input = "Electrical Engineering";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("all uppercase letters -> true")
    void testIsDepartmentNameValid8() {
        String input = "BIOLOGY";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("all lowercase letters -> true")
    void testIsDepartmentNameValid9() {
        String input = "chemistry";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("mixed case letters -> true")
    void testIsDepartmentNameValid10() {
        String input = "Physics Department";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }
}
