package test.Integration_test;


import main.Main;
import main.academic.*;
import main.file.*;
import main.grading.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    @Test
    public void testSubjectStudentIntegration() {
        // Test integration of Subject, Student, and SubjectWork classes
        Subject subject = new Subject();
        subject.setSubjectName("Mathematics");
        subject.setSubjectCode("MATH101");

        Student student = new Student();
        student.setName("John Doe");
        student.setNumber("12345678");

        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setSubjectCode("MATH101");
        subjectWork.setActivitiesMark(8);
        subjectWork.setPracticalMark(9);
        subjectWork.setMidtermMark(18);
        subjectWork.setFinalMark(55);

        student.getStudentSubjects().put("MATH101", subjectWork);

        // Assertions
        assertEquals("Mathematics", subject.getSubjectName());
        assertEquals("MATH101", subject.getSubjectCode());

        assertEquals("John Doe", student.getName());
        assertEquals("12345678", student.getNumber());

        assertEquals("MATH101", subjectWork.getSubjectCode());
        assertEquals(Integer.valueOf(8), subjectWork.getActivitiesMark());
        assertEquals(Integer.valueOf(9), subjectWork.getPracticalMark());
        assertEquals(Integer.valueOf(18), subjectWork.getMidtermMark());
        assertEquals(Integer.valueOf(55), subjectWork.getFinalMark());
    }

    @Test
    public void testCalculatorIntegration() {
        // Test integration of Calculator class with SubjectWork class
        SubjectWork subjectWork = new SubjectWork();
        subjectWork.setActivitiesMark(8);
        subjectWork.setPracticalMark(9);
        subjectWork.setMidtermMark(18);
        subjectWork.setFinalMark(55);

        // Calculate GPA and Grade
        Calculator.calculateGradeAndGPA(subjectWork);

        // Assertions
        assertEquals(Double.valueOf(2.92), subjectWork.getGPA());
        assertEquals("B", subjectWork.getGrade());
    }

    @Test
    public void testFileReaderWriterIntegration() {
        // Test integration of FileReaderManager and FileWriterManager classes
        try {
            // Prepare test input file
            Path inputFilePath = Paths.get("src/main/file/resources/test_input.txt");
            FileReaderManager readerManager = new FileReaderManager(inputFilePath.toString());
            Subject subject = readerManager.getSubject();
            List<Student> students = readerManager.getStudents();

            // Assertions for FileReaderManager
            assertNotNull(subject);
            assertNotNull(students);
            assertFalse(students.isEmpty());

            // Test FileWriterManager
            Path outputFilePath = Paths.get("src/main/file/resources/test_output.txt");
            FileWriterManager.writeToFile(outputFilePath.toString(), subject, students);
            // You can add assertions to check if the output file is generated correctly.
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during integration testing: " + e.getMessage());
        }
    }

    @Test
    public void testMainIntegration() {
        // Test integration of all components by running the main method of the Main class
        try {
            Path inputFilePath = Paths.get("src/main/file/resources/test_input.txt");
            Path outputFilePath = Paths.get("src/main/file/resources/test_output.txt");

            // Execute main method
            Main.main(null);

            // Read the generated output file
            FileReaderManager readerManager = new FileReaderManager(outputFilePath.toString());
            Subject subject = readerManager.getSubject();
            List<Student> students = readerManager.getStudents();

            // Assertions
            assertNotNull(subject);
            assertNotNull(students);
            assertFalse(students.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during integration testing: " + e.getMessage());
        }
    }
}
