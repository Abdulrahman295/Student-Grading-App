package main.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import main.academic.*;

public class FileWriterManager {
    public static void writeToFile(String outputPath, Subject subject, List<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write("Subject Name: " + subject.getSubjectName() + "   Max Mark: " + subject.getSubjectFullMark());
            writer.newLine();
            writer.write("Student name    Student number    GPA       Grade");
            writer.newLine();

            for (Student student : students) {
                String studentLine = formatStudentRecord(student, subject.getSubjectCode());
                writer.write(studentLine);
                writer.newLine();
            }
        }
    }

    private static String formatStudentRecord(Student student, String subjectCode) {
        String name = student.getName();
        String number = student.getNumber();
        double gpa = student.getStudentSubjects().get(subjectCode).getGPA(); // Implement this method based on your
                                                                             // logic
        String grade = student.getStudentSubjects().get(subjectCode).getGrade(); // Implement this method based on your
                                                                                 // logic

        return String.format("%-15s  %-15s  %-10.2f  %-5s", name, number, gpa, grade);
    }
}
