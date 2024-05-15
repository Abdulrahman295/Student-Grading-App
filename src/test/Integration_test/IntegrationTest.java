package test.Integration_test;

import main.academic.*;
import main.file.*;
import main.grading.*;
import main.app.StudentGradingApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    private static final String INPUT_FILE_PATH = "src/main/file/resources/input.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/file/resources/output.txt";
    private static final String EMPTY_INPUT_FILE_PATH = "src/main/file/resources/empty_input.txt";
    private static final String MALFORMED_INPUT_FILE_PATH = "src/main/file/resources/malformed_input.txt";
    private static final String INVALID_INPUT_FILE_PATH = "invalid_path.txt";

    private StudentGradingApp app;

    @BeforeEach
    public void setUp() {
        app = new StudentGradingApp(INPUT_FILE_PATH, OUTPUT_FILE_PATH);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get(OUTPUT_FILE_PATH));
    }

    @Test
    public void testFileReaderManagerWithValidInputFile() throws Exception {
        FileReaderManager readerManager = new FileReaderManager(INPUT_FILE_PATH);
        assertNotNull(readerManager.getSubject());
        List<Student> students = readerManager.getStudents();
        assertFalse(students.isEmpty());
        Subject subject = readerManager.getSubject();
        // Check if the subject and student objects are correctly populated
        assertEquals("Mathematics", subject.getSubjectName());
        assertEquals("CSE101", subject.getSubjectCode());
        assertEquals(4, students.size());

        // Add more assertions to check the content of students list
        assertEquals("John Doe", students.get(0).getName());
        assertEquals("Jane Smith", students.get(1).getName());
        assertEquals("Alice Johnson", students.get(2).getName());
        assertEquals("Hossam Eid", students.get(3).getName());
    }

    @Test
    public void testFileReaderManagerWithEmptyInputFile() throws Exception {
        FileReaderManager readerManager = new FileReaderManager(EMPTY_INPUT_FILE_PATH);
        assertNotNull(readerManager.getSubject());
        List<Student> students = readerManager.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    void testFileReaderManagerWithMalformedInputFile() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FileReaderManager(MALFORMED_INPUT_FILE_PATH);
        });
    }

    @Test
    public void testCalculatorWithDifferentCombinationsOfMarks() throws Exception {
        FileReaderManager readerManager = new FileReaderManager(INPUT_FILE_PATH);
        List<Student> students = readerManager.getStudents();
        Subject subject = readerManager.getSubject();
        for (Student student : students) {
            SubjectWork work = student.getStudentSubjects().get(subject.getSubjectCode());
            Calculator.calculateGradeAndGPA(work);
            assertNotNull(work.getGPA());
            assertNotNull(work.getGrade());
            // Add more assertions to check the calculation logic
            assertTrue(work.getGPA() >= 0 && work.getGPA() <= 4);
            assertTrue(work.getGrade().matches("^[A-F][+-]?$"));
        }
    }

    @Test
    public void testCalculatorWithExtremeValues() throws Exception {
        FileReaderManager readerManager = new FileReaderManager(INPUT_FILE_PATH);
        List<Student> students = readerManager.getStudents();
        Subject subject = readerManager.getSubject();
        for (Student student : students) {
            SubjectWork work = student.getStudentSubjects().get(subject.getSubjectCode());
            // Maximum marks
            work.setActivitiesMark(100);
            work.setPracticalMark(100);
            work.setMidtermMark(100);
            work.setFinalMark(100);
            Calculator.calculateGradeAndGPA(work);
            assertEquals("A+", work.getGrade());
            assertEquals(4.0, work.getGPA(), 0.001);

            // Minimum marks
            work.setActivitiesMark(0);
            work.setPracticalMark(0);
            work.setMidtermMark(0);
            work.setFinalMark(0);
            Calculator.calculateGradeAndGPA(work);
            assertEquals("F", work.getGrade());
            assertEquals(0.0, work.getGPA(), 0.001);
        }
    }

    @Test
    public void testFileWriterManager() throws Exception {
        app.calculateStudentsGrades();
        assertTrue(Files.exists(Paths.get(OUTPUT_FILE_PATH)));
        // Add assertions to check the content of the output file
        List<String> outputLines = Files.readAllLines(Paths.get(OUTPUT_FILE_PATH));
        assertFalse(outputLines.isEmpty());
        assertTrue(outputLines.get(0).contains("Mathematics"));
    }

    @Test
    public void testStudentGradingAppWithValidInputFile() throws Exception {
        app.calculateStudentsGrades();
        assertTrue(Files.exists(Paths.get(OUTPUT_FILE_PATH)));
        // Add assertions to check the content of the output file
        List<String> outputLines = Files.readAllLines(Paths.get(OUTPUT_FILE_PATH));
        assertFalse(outputLines.isEmpty());
        assertTrue(outputLines.get(0).contains("Mathematics"));
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("John Doe")));
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("Jane Smith")));
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("Alice Johnson")));
        assertTrue(outputLines.stream().anyMatch(line -> line.contains("Hossam Eid")));
    }

    @Test
    void testCalculatorWithNullInputForMarks() throws Exception {
        FileReaderManager readerManager = new FileReaderManager(INPUT_FILE_PATH);
        List<Student> students = readerManager.getStudents();
        Subject subject = readerManager.getSubject();
        Student student = students.get(0);
        SubjectWork work = student.getStudentSubjects().get(subject.getSubjectCode());

        assertThrows(IllegalArgumentException.class, () -> {
            work.setActivitiesMark(null); // Setting a mark as null
            Calculator.calculateGradeAndGPA(work);
        });
    }

    @Test
    void testStudentGradingAppWithEmptyInputFile() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentGradingApp emptyApp = new StudentGradingApp(EMPTY_INPUT_FILE_PATH, OUTPUT_FILE_PATH);
            emptyApp.calculateStudentsGrades();
        });
    }

    @Test
    void testStudentGradingAppWithInvalidFilePath() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new StudentGradingApp(INVALID_INPUT_FILE_PATH, OUTPUT_FILE_PATH);
        });
    }
}