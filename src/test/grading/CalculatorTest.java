package test.grading;

import main.grading.Calculator;
import main.academic.SubjectWork;
import java.util.AbstractMap.SimpleEntry;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCalculateGradeAndGPA_APlus() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(97); // Assuming other marks are 0
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("A+", result.getKey());
        assertEquals(4.0, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_A() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(93);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("A", result.getKey());
        assertEquals(4.0, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_AMinus() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(89);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("A-", result.getKey());
        assertEquals(3.7, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_BPlus() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(84);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("B+", result.getKey());
        assertEquals(3.3, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_B() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(80);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("B", result.getKey());
        assertEquals(3.0, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_BMinus() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(76);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("B-", result.getKey());
        assertEquals(2.7, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_CPlus() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(73);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("C+", result.getKey());
        assertEquals(2.3, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_C() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(70);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("C", result.getKey());
        assertEquals(2.0, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_CMinus() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(67);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("C-", result.getKey());
        assertEquals(1.7, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_DPlus() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(64);
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("D+", result.getKey());
        assertEquals(1.3, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_F() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(59); 
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("F", result.getKey());
        assertEquals(0.0, result.getValue());
    }

    @Test
    void testCalculateGradeAndGPA_Boundary() {
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setTotalMark(60); 
        SimpleEntry<String, Double> result = Calculator.calculateGradeAndGPA(subjectWork);
        assertEquals("D", result.getKey());
        assertEquals(1.0, result.getValue());
    }
}

