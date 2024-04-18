package main.academic;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String number;

    private Map<String, SubjectWork> studentSubjects;

    public Student (){
        studentSubjects = new HashMap<String, SubjectWork>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }

        if (name.startsWith(" ")) {
            throw new IllegalArgumentException("name cannot start with space");
        }

        if (!name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
            throw new IllegalArgumentException("name must be Alphabetic characters and Spaces only");
        }

        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws IllegalArgumentException{
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("studentNumber cannot be null or empty");
        }

        if (number.length() != 8) {
            throw new IllegalArgumentException("studentNumber must be 8 characters");
        }
        
        if (!number.matches("^[0-9]{7}[a-zA-Z]?$")) {
            throw new IllegalArgumentException("Student number must start with 7 numbers and may end with one optional alphabetic character, total length must be exactly 8 characters.");
        }

        if (!number.matches("^[0-9a-zA-Z]+")) {
            throw new IllegalArgumentException("studentNumber must be Alphanumeric characters");
        }

        this.number = number;
    }

    public Map<String, SubjectWork> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(Map<String, SubjectWork> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
}
