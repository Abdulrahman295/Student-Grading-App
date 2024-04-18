package main.academic;

public class Subject {
    private String subjectName;
    private String subjectCode;
    private int subjectFullMark = 100;

    public Subject() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) throws IllegalArgumentException {
        if (subjectName == null || subjectName.isEmpty()) {
            throw new IllegalArgumentException("subjectName cannot be null or empty");
        }

        if (subjectName.startsWith(" ")) {
            throw new IllegalArgumentException("subjectName cannot start with space");
        }

        if (!subjectName.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
            throw new IllegalArgumentException("subjectName must be Alphabetic characters and Spaces only");
        }

        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) throws IllegalArgumentException{
        if (subjectCode == null || subjectCode.isEmpty()) {
            throw new IllegalArgumentException("subjectCode cannot be null or empty");
        }

        if (subjectCode.length() < 6 || subjectCode.length() > 7) {
            throw new IllegalArgumentException("subjectCode must be 6 to 7 characters in length");
        }

        if (!subjectCode.substring(0, 3).matches("^[a-zA-Z]+")) {
            throw new IllegalArgumentException("the first 3 characters must be alphabetic");
        }

        if (subjectCode.length() == 7) {
            if (!subjectCode.substring(4, 6).matches("^[0-9]+")) {
                throw new IllegalArgumentException("the last 3 must be numeric");
            }

            if (!subjectCode.substring(6, 7).matches("^[s]")) {
                throw new IllegalArgumentException("if the length is 7, the last character must be 's'");
            }
        } else {
            if (!subjectCode.substring(3).matches("^[0-9]+")) {
                throw new IllegalArgumentException("the last 3 must be numeric");
            }
        }

        this.subjectCode = subjectCode;
    }

    public int getSubjectFullMark() {
        return subjectFullMark;
    }

    public void setSubjectFullMark(int subjectFullMark) {
        if (subjectFullMark < 0) {
            throw new IllegalArgumentException("subjectFullMark cannot be negative");
        }

        if (subjectFullMark > 100) {
            throw new IllegalArgumentException("subjectFullMark cannot be greater than 100");
        }

        this.subjectFullMark = subjectFullMark;
    }
}
