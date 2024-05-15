package main.app;

import main.academic.*;
import main.file.*;
import main.grading.*;
import java.nio.file.*;
import java.util.List;

public class StudentGradingApp {
    private final String inputFilePath;
    private final String outputFilePath;

    /**
     * The constructor for the StudentGradingApp
     * 
     * @param inputFilePath  : the path to the file containing the the student's
     *                       information.
     * @param outputFilePath : the path where to create the output file containing
     *                       the student's results.
     */
    public StudentGradingApp(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    /**
     * Function to read the student's information from the input file and
     * write the student's results to the output file.
     * 
     * @throws Exception
     */
    public void calculateStudentsGrades() throws Exception {
        try {
            Path path = Paths.get(inputFilePath);

            if (!Files.exists(path)) {
                throw new IllegalArgumentException("Resource file not found at " + path);
            }

            String filePath = path.toString();

            FileReaderManager readerManager = new FileReaderManager(filePath);

            Subject subject = readerManager.getSubject();

            List<Student> students = readerManager.getStudents();

            for (Student student : students) {
                SubjectWork work = student.getStudentSubjects().get(subject.getSubjectCode());
                Double subjectGPA = Calculator.calculateGradeAndGPA(work).getValue();
                String subjectGrade = Calculator.calculateGradeAndGPA(work).getKey();
                work.setGPA(subjectGPA);
                work.setGrade(subjectGrade);
            }

            FileWriterManager.writeToFile(outputFilePath, subject, students);

            System.out.println("The students grades was calculated successfully!.");
        } catch (Exception e) {
            throw e;
        }

    }
}
