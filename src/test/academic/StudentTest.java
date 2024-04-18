package test.academic;

import main.academic.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Test
    void setNameValidName() {
        String validName = "John Doe";
        assertDoesNotThrow(() -> student.setName(validName));
        assertEquals(validName, student.getName());
    }

    @Test
    void setNameWithNullThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setName(null));
        assertTrue(exception.getMessage().contains("name cannot be null or empty"));
    }

    @Test
    void setNameWithEmptyStringThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setName(""));
        assertTrue(exception.getMessage().contains("name cannot be null or empty"));
    }

    @Test
    void setNameWithLeadingSpaceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setName(" John"));
        assertTrue(exception.getMessage().contains("name cannot start with space"));
    }

    @Test
    void setNameWithInvalidCharactersThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setName("John123"));
        assertTrue(exception.getMessage().contains("name must be Alphabetic characters and Spaces only"));
    }

    @Test
    void setNumberValidNumber() {
        String validNumber = "1234567A";
        assertDoesNotThrow(() -> student.setNumber(validNumber));
        assertEquals(validNumber, student.getNumber());
    }

    @Test
    void setNumberValidNumberWithoutLetter() {
        String validNumber = "12345678";
        assertDoesNotThrow(() -> student.setNumber(validNumber));
        assertEquals(validNumber, student.getNumber());
    }

    @Test
    void setNumberWithNullThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setNumber(null));
        assertTrue(exception.getMessage().contains("studentNumber cannot be null or empty"));
    }

    @Test
    void setNumberWithEmptyStringThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setNumber(""));
        assertTrue(exception.getMessage().contains("studentNumber cannot be null or empty"));
    }

    @Test
    void setNumberWithInvalidLengthThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setNumber("1234567"));
        assertTrue(exception.getMessage().contains("studentNumber must be 8 characters"));
    }

    @Test
    void setNumberWithInvalidFormatThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.setNumber("A2345678"));
        assertTrue(exception.getMessage().contains("Student number must start with 7 numbers and may end with one optional alphabetic character"));
    }
}
