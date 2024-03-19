package main.academic;

public class Subject {
    private String subjectName;
    private String subjectCode;
    private int subjectFullMark;

    public Subject() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getSubjectFullMark() {
        return subjectFullMark;
    }

    public void setSubjectFullMark(int subjectFullMark) {
        this.subjectFullMark = subjectFullMark;
    }
}
