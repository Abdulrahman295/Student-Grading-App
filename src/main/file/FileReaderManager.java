package main.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.academic.*;

public class FileReaderManager {
    private Subject subject;
    private List<Student> students;

    public FileReaderManager(String filePath) throws IOException {
        this.students = new ArrayList<>();
        readFromFile(filePath);
    }

    private void readFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                // Initialize the subject with the first line
                String[] subjectDetails = line.split(",");
                this.subject = new Subject();
                this.subject.setSubjectName(subjectDetails[0].trim());
                this.subject.setSubjectCode(subjectDetails[1].trim());

                while ((line = reader.readLine()) != null) {
                    String[] details = line.split(",");
                    Student student = new Student();
                    student.setName(details[0].trim());
                    student.setNumber(details[1].trim());

                    // Create and set SubjectWork for the student
                    SubjectWork work = new SubjectWork();
                    work.setActivitiesMark(Integer.parseInt(details[2].trim()));
                    work.setPracticalMark(Integer.parseInt(details[3].trim()));
                    work.setMidtermMark(Integer.parseInt(details[4].trim()));
                    work.setFinalMark(Integer.parseInt(details[5].trim()));

                    student.getStudentSubjects().put(subject.getSubjectCode(), work);
                    students.add(student);
                }
            } else {
                throw new IllegalArgumentException("The provided file is empty");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Subject getSubject() {
        return subject;
    }

    public List<Student> getStudents() {
        return students;
    }
}
