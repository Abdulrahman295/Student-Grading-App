package test.academic;

import main.academic.SubjectWork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubjectWorkTest {
    private SubjectWork subjectWork;

    @BeforeEach
    void setUp() {
        subjectWork = new SubjectWork();
    }

    @Test
    void setSubjectCodeValid() {
        assertDoesNotThrow(() -> subjectWork.setSubjectCode("MAT123"));
        assertEquals("MAT123", subjectWork.getSubjectCode());
    }

    @Test
    void setSubjectCodeValidWith7Characters() {
        assertDoesNotThrow(() -> subjectWork.setSubjectCode("MAT123s"));
        assertEquals("MAT123s", subjectWork.getSubjectCode());
    }

    @Test
    void setSubjectCodeNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setSubjectCode(null));
    }

    @Test
    void setSubjectCodeEmptyThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setSubjectCode(""));
    }

    @Test
    void setSubjectCodeInvalidLengthThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setSubjectCode("MAT12"));
    }

    @Test
    void setSubjectCodeInvalidFormatThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setSubjectCode("123MAT"));
    }

    @Test
    void setActivitiesMarkValid() {
        assertDoesNotThrow(() -> subjectWork.setActivitiesMark(5));
        assertEquals(5, subjectWork.getActivitiesMark());
    }

    @Test
    void setActivitiesMarkNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setActivitiesMark(null));
    }

    @Test
    void setActivitiesMarkOutOfRangeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setActivitiesMark(11));
    }

    @Test
    void setPracticalMarkValid() {
        assertDoesNotThrow(() -> subjectWork.setPracticalMark(5));
        assertEquals(5, subjectWork.getPracticalMark());
    }

    @Test
    void setPracticalMarkNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setPracticalMark(null));
    }

    @Test
    void setPracticalMarkOutOfRangeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setPracticalMark(11));
    }

    @Test
    void setMidtermMarkValid() {
        assertDoesNotThrow(() -> subjectWork.setMidtermMark(15));
        assertEquals(15, subjectWork.getMidtermMark());
    }

    @Test
    void setMidtermMarkNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setMidtermMark(null));
    }

    @Test
    void setMidtermMarkOutOfRangeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setMidtermMark(21));
    }

    @Test
    void setFinalMarkValid() {
        assertDoesNotThrow(() -> subjectWork.setFinalMark(55));
        assertEquals(55, subjectWork.getFinalMark());
    }

    @Test
    void setFinalMarkNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setFinalMark(null));
    }

    @Test
    void setFinalMarkOutOfRangeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setFinalMark(61));
    }

    @Test
    void setGPAValid() {
        assertDoesNotThrow(() -> subjectWork.setGPA(3.5));
        assertEquals(3.5, subjectWork.getGPA());
    }

    @Test
    void setGPANullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setGPA(null));
    }

    @Test
    void setGPAOutOfRangeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setGPA(4.1));
    }

    @Test
    void setGradeValid() {
        assertDoesNotThrow(() -> subjectWork.setGrade("A"));
        assertEquals("A", subjectWork.getGrade());
    }

    @Test
    void setGradeValidWithPlus() {
        assertDoesNotThrow(() -> subjectWork.setGrade("A+"));
        assertEquals("A+", subjectWork.getGrade());
    }

    @Test
    void setGradeNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setGrade(null));
    }

    @Test
    void setGradeEmptyThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setGrade(""));
    }

    @Test
    void setGradeInvalidFormatThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subjectWork.setGrade("Invalid"));
    }
}
