package main;

import main.academic.*;
import main.file.*;
import main.grading.*;
import java.nio.file.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {   
            Path path = Paths.get("src/main/file/resources/input.txt");
                
             if (!Files.exists(path)) {
                throw new IllegalArgumentException("Resource file not found at " + path);
            }

            String filePath = path.toString();

            FileReaderManager readerManager = new FileReaderManager(filePath);

            Subject subject = readerManager.getSubject();

            List<Student>  students = readerManager.getStudents();

            for (Student student : students) {
                SubjectWork work = student.getStudentSubjects().get(subject.getSubjectCode());
                Double subjectGPA = Calculator.calculateGradeAndGPA(work).getValue();
                String subjectGrade = Calculator.calculateGradeAndGPA(work).getKey();
                work.setGPA(subjectGPA);
                work.setGrade(subjectGrade);
            }
            
            FileWriterManager.writeToFile("src/main/file/resources/output.txt", subject, students);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}