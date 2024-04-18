package test.academic;

import main.academic.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {
    private Subject subject;

    @BeforeEach
    void setUp() {
        subject = new Subject();
    }

    @Test
    void setSubjectNameValid() {
        String validName = "Mathematics";
        assertDoesNotThrow(() -> subject.setSubjectName(validName));
        assertEquals(validName, subject.getSubjectName());
    }

    @Test
    void setSubjectNameNullThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectName(null));
        assertTrue(exception.getMessage().contains("subjectName cannot be null or empty"));
    }

    @Test
    void setSubjectNameEmptyThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectName(""));
        assertTrue(exception.getMessage().contains("subjectName cannot be null or empty"));
    }

    @Test
    void setSubjectNameStartsWithSpaceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectName(" Mathematics"));
        assertTrue(exception.getMessage().contains("subjectName cannot start with space"));
    }

    @Test
    void setSubjectNameInvalidCharactersThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectName("Math123"));
        assertTrue(exception.getMessage().contains("subjectName must be Alphabetic characters and Spaces only"));
    }

    @Test
    void setSubjectCodeValid() {
        String validCode = "CSE101";
        assertDoesNotThrow(() -> subject.setSubjectCode(validCode));
        assertEquals(validCode, subject.getSubjectCode());
    }

    @Test
    void setSubjectCodeValidWithSevenCharacters() {
        String validCode = "CSE101s";
        assertDoesNotThrow(() -> subject.setSubjectCode(validCode));
        assertEquals(validCode, subject.getSubjectCode());
    }

    @Test
    void setSubjectCodeNullThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectCode(null));
        assertTrue(exception.getMessage().contains("subjectCode cannot be null or empty"));
    }

    @Test
    void setSubjectCodeEmptyThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectCode(""));
        assertTrue(exception.getMessage().contains("subjectCode cannot be null or empty"));
    }

    @Test
    void setSubjectCodeLengthTooShortThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectCode("CSE"));
        assertTrue(exception.getMessage().contains("subjectCode must be 6 to 7 characters in length"));
    }

    @Test
    void setSubjectCodeLengthTooLongThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectCode("CSE10123"));
        assertTrue(exception.getMessage().contains("subjectCode must be 6 to 7 characters in length"));
    }

    @Test
    void setSubjectCodeInvalidCharactersThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectCode("123456"));
        assertTrue(exception.getMessage().contains("the first 3 characters must be alphabetic"));
    }

    @Test
    void setSubjectCodeInvalidEndingCharacterThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectCode("CSE101a"));
        assertTrue(exception.getMessage().contains("if the length is 7, the last character must be 's'"));
    }

    @Test
    void setSubjectFullMarkValid() {
        int validMark = 100;
        assertDoesNotThrow(() -> subject.setSubjectFullMark(validMark));
        assertEquals(validMark, subject.getSubjectFullMark());
    }

    @Test
    void setSubjectFullMarkNegativeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectFullMark(-1));
        assertTrue(exception.getMessage().contains("subjectFullMark cannot be negative"));
    }

    @Test
    void setSubjectFullMarkTooHighThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> subject.setSubjectFullMark(101));
        assertTrue(exception.getMessage().contains("subjectFullMark cannot be greater than 100"));
    }
}

