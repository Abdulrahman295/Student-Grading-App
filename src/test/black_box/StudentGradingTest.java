package test.black_box;

import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;
import main.app.StudentGradingApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentGradingTest {

    @Test
    public void testValidInput() throws Exception {

        String inputFilePath = "src/test/black_box/resources/valid_data.txt";
        String outputFilePath = "src/test/black_box/resources/output.txt";

        StudentGradingApp app = new StudentGradingApp(inputFilePath, outputFilePath);
        app.calculateStudentsGrades();

        // Assertions for successful processing and output file existence
        assertTrue(Files.exists(Paths.get(outputFilePath)), "Output file should be generated");

        List<String> lines = Files.readAllLines(Paths.get(outputFilePath));
        assertEquals(6, lines.size(), "Should write 6 lines (Subject, header, and 4 students)");
        assertTrue(lines.get(0).contains("Subject Name: Mathematics   Max Mark: 100"));
        assertTrue(lines.get(1).contains("Student name    Student number    GPA       Grade"));
        assertTrue(lines.get(2).contains("John Doe         1234567A         2.70        B-   "));
        assertTrue(lines.get(3).contains("Jane Smith       1234567B         3.30        B+   "));
        assertTrue(lines.get(4).contains("Alice Johnson    1234567C         4.00        A    "));
        assertTrue(lines.get(5).contains("Hossam Eid       1234567D         4.00        A+   "));
    }

    @Test
    public void testInvalidInputFilePath() throws Exception {
        // Invalid file path (doesn't exist)
        String inputFilePath = "src/test/black_box/resources/invalid_file.txt";
        String outputFilePath = "src/test/black_box/resources/output.txt";

        StudentGradingApp app = new StudentGradingApp(inputFilePath, outputFilePath);

        // Use assertThrows to verify the expected exception is thrown
        assertThrows(IllegalArgumentException.class, () -> app.calculateStudentsGrades());
    }

    @Test
    public void testEmptySubjectNameInInputFile() throws Exception {

        String inputFilePath = "src/test/black_box/resources/empty_subject_name.txt";
        String outputFilePath = "src/test/black_box/resources/output.txt";

        StudentGradingApp app = new StudentGradingApp(inputFilePath, outputFilePath);

        assertThrows(IllegalArgumentException.class, () -> app.calculateStudentsGrades());
    }

    @Test
    public void testSpecialCharInSubjectNameInInputFile() throws Exception {

        String inputFilePath = "src/test/black_box/resources/special_char_subject_name.txt";
        String outputFilePath = "src/test/black_box/resources/output.txt";

        StudentGradingApp app = new StudentGradingApp(inputFilePath, outputFilePath);

        assertThrows(IllegalArgumentException.class, () -> app.calculateStudentsGrades());
    }

    @Test
    public void testEmptyStudentNameInInputFile() throws Exception {

        String inputFilePath = "src/test/black_box/resources/empty_student_name.txt";
        String outputFilePath = "src/test/black_box/resources/output.txt";

        StudentGradingApp app = new StudentGradingApp(inputFilePath, outputFilePath);

        assertThrows(IllegalArgumentException.class, () -> app.calculateStudentsGrades());
    }

    @Test
    public void testSpecialCharInStudentNameInInputFile() throws Exception {

        String inputFilePath = "src/test/black_box/resources/special_char_student_name.txt";
        String outputFilePath = "src/test/black_box/resources/output.txt";

        StudentGradingApp app = new StudentGradingApp(inputFilePath, outputFilePath);

        assertThrows(IllegalArgumentException.class, () -> app.calculateStudentsGrades());
    }

    @Test
    public void testEmptyInputFile() throws Exception {
        // Replace with your actual empty data file path
        String inputFilePath = "src/test/black_box/resources/empty_data.txt";
        String outputFilePath = "src/test/black_box/resources/output.txt";

        StudentGradingApp app = new StudentGradingApp(inputFilePath, outputFilePath);
        assertThrows(IllegalArgumentException.class, () -> app.calculateStudentsGrades());
    }

}
