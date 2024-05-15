package test.file;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import main.academic.*;
import main.file.FileWriterManager;

class FileWriterManagerTest {

    private static Path tempFile;
    private Subject subject;
    private List<Student> students;

    @BeforeEach
    void setUp() throws IOException {
        // Setup a temporary file
        tempFile = Files.createTempFile("testFileWriter", ".txt");

        // Setup subject
        subject = new Subject();
        subject.setSubjectName("Mathematics");
        subject.setSubjectCode("MTH101");

        // Setup students
        students = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setNumber("12345678");

        SubjectWork work1 = new SubjectWork();
        work1.setGPA(3.5);
        work1.setGrade("A");

        student1.getStudentSubjects().put(subject.getSubjectCode(), work1);
        students.add(student1);

        Student student2 = new Student();
        student2.setName("Jane Doe");
        student2.setNumber("87654321");

        SubjectWork work2 = new SubjectWork();
        work2.setGPA(3.2);
        work2.setGrade("B");

        student2.getStudentSubjects().put(subject.getSubjectCode(), work2);
        students.add(student2);
    }

    @Test
    void testWriteToFile() throws IOException {
        FileWriterManager.writeToFile(tempFile.toString(), subject, students);

        // Read back the file to check contents
        List<String> lines = Files.readAllLines(tempFile);
        assertEquals(4, lines.size(), "Should write 4 lines (Subject, header, and 2 students)");
        assertTrue(lines.get(0).contains("Subject Name: Mathematics   Max Mark: 100"));
        assertTrue(lines.get(1).contains("Student name    Student number    GPA       Grade"));
        assertTrue(lines.get(2).contains("John Doe         12345678         3.50        A    "));
        assertTrue(lines.get(3).contains("Jane Doe         87654321         3.20        B    "));
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up the temporary file
        Files.deleteIfExists(tempFile);
    }
}
