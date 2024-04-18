package test.file;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import main.academic.*;
import main.file.FileReaderManager;

class FileReaderManagerTest {

    private static final String TEST_FILE_PATH = "src/test/file/resources/testInput.txt";

    @BeforeAll
    static void setup() throws IOException {
        // Prepare a test file with known content
        List<String> lines = List.of(
            "Mathematics,CSE101",
            "John Doe,1234567A,10,9,15,45",
            "Jane Doe,1234567B,9,8,14,44"
        );
        Path file = Paths.get(TEST_FILE_PATH);
        Files.write(file, lines);
    }

    @Test
    void testReadFromFile() throws IOException {
        FileReaderManager fileReaderManager = new FileReaderManager(TEST_FILE_PATH);

        Subject subject = fileReaderManager.getSubject();
        List<Student> students = fileReaderManager.getStudents();

        assertNotNull(subject, "Subject should not be null");
        assertEquals("Mathematics", subject.getSubjectName());
        assertEquals("CSE101", subject.getSubjectCode());

        assertNotNull(students, "Students list should not be null");
        assertEquals(2, students.size(), "There should be two students");

        // Check first student
        Student firstStudent = students.get(0);
        assertEquals("John Doe", firstStudent.getName());
        assertEquals("1234567A", firstStudent.getNumber());
        SubjectWork firstWork = firstStudent.getStudentSubjects().get("CSE101");
        assertNotNull(firstWork, "SubjectWork for the first student should not be null");
        assertEquals(Integer.valueOf(10), firstWork.getActivitiesMark());
        assertEquals(Integer.valueOf(9), firstWork.getPracticalMark());
        assertEquals(Integer.valueOf(15), firstWork.getMidtermMark());
        assertEquals(Integer.valueOf(45), firstWork.getFinalMark());

        // Check second student
        Student secondStudent = students.get(1);
        assertEquals("Jane Doe", secondStudent.getName());
        assertEquals("1234567B", secondStudent.getNumber());
        SubjectWork secondWork = secondStudent.getStudentSubjects().get("CSE101");
        assertNotNull(secondWork, "SubjectWork for the second student should not be null");
        assertEquals(Integer.valueOf(9), secondWork.getActivitiesMark());
        assertEquals(Integer.valueOf(8), secondWork.getPracticalMark());
        assertEquals(Integer.valueOf(14), secondWork.getMidtermMark());
        assertEquals(Integer.valueOf(44), secondWork.getFinalMark());
    }

    @AfterAll
    static void cleanup() throws IOException {
        // Clean up the test file
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
    }
}