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

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Map<String, SubjectWork> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(Map<String, SubjectWork> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
}
