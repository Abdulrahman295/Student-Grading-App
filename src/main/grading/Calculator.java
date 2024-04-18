package main.grading;
import main.academic.*;
import java.util.AbstractMap.SimpleEntry;

public class GPACalc {

    public GPACalc() {
        
    }

    public SimpleEntry<String, Double> calculateGradeAndGPA(SubjectWork subjectWork){

        Integer totalMarks = subjectWork.getTotalMark();
        Double gpa = 0.0;
        String grade = "";

        if (totalMarks >= 97 && totalMarks <= 100) {
            gpa = 4.0;
            grade = "A+";
        } else if (totalMarks >= 93 && totalMarks < 97) {
            gpa = 4.0;
            grade = "A";
        } else if (totalMarks >= 89 && totalMarks < 93) {
            gpa = 3.7;
            grade = "A-";
        } else if (totalMarks >= 84 && totalMarks < 89) {
            gpa = 3.3;
            grade = "B+";
        } else if (totalMarks >= 80 && totalMarks < 84) {
            gpa = 3.0;
            grade = "B";
        } else if (totalMarks >= 76 && totalMarks < 80) {
            gpa = 2.7;
            grade = "B-";
        } else if (totalMarks >= 73 && totalMarks < 76) {
            gpa = 2.3;
            grade = "C+";
        } else if (totalMarks >= 70 && totalMarks < 73) {
            gpa = 2.0;
            grade = "C";
        } else if (totalMarks >= 67 && totalMarks < 70) {
            gpa = 1.7;
            grade = "C-";
        } else if (totalMarks >= 64 && totalMarks < 67) {
            gpa = 1.3;
            grade = "D+";
        } else if (totalMarks >= 60 && totalMarks < 64) {
            gpa = 1.0;
            grade = "D";
        } else {
            gpa = 0.0;
            grade = "F";
        }

        return new SimpleEntry<String, Double>(grade, gpa);
    }

    
}
