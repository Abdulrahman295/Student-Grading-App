package main.academic;

public class SubjectWork {
    private String subjectCode;
    private Integer activitiesMark;
    private Integer practicalMark;
    private Integer midtermMark;
    private Integer finalMark;
    private Integer totalMark;
    private Double GPA;
    private String grade;

    public SubjectWork(){
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

    public Integer getActivitiesMark() {
        return activitiesMark;
    }

    public void setActivitiesMark(Integer activitiesMark) throws IllegalArgumentException{
        if (activitiesMark == null) {
            throw new IllegalArgumentException("activitiesMark cannot be null");
        }

        if (activitiesMark < 0 || activitiesMark > 10) {
            throw new IllegalArgumentException("activitiesMark must be between 0 and 10");
        }
       
        this.activitiesMark = activitiesMark;
    }

    public Integer getPracticalMark() {
        return practicalMark;
    }

    public void setPracticalMark(Integer practicalMark) throws IllegalArgumentException{
        if (practicalMark == null) {
            throw new IllegalArgumentException("practicalMark cannot be null");
        }

        if (practicalMark < 0 || practicalMark > 10) {
            throw new IllegalArgumentException("practicalMark must be between 0 and 10");
        }

        this.practicalMark = practicalMark;
    }

    public Integer getMidtermMark() {
        return midtermMark;
    }

    public void setMidtermMark(Integer midtermMark) throws IllegalArgumentException{
        if (midtermMark == null) {
            throw new IllegalArgumentException("midtermMark cannot be null");
        }

        if (midtermMark < 0 || midtermMark > 20) {
            throw new IllegalArgumentException("midtermMark must be between 0 and 20");
        }

        this.midtermMark = midtermMark;
    }

    public Integer getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(Integer finalMark) throws IllegalArgumentException{
        if (finalMark == null) {
            throw new IllegalArgumentException("finalMark cannot be null");
        }

        if (finalMark < 0 || finalMark > 60) {
            throw new IllegalArgumentException("finalMark must be between 0 and 60");
        }

        this.finalMark = finalMark;
    }

    public Integer getTotalMark() {
        if(this.totalMark == null){
            this.totalMark = this.activitiesMark + this.practicalMark + this.midtermMark + this.finalMark;
        }
        
        return this.totalMark;
    }

    public void setTotalMark(Integer totalMark){
        if (totalMark == null) {
            throw new IllegalArgumentException("totalMark cannot be null");
        }

        if (totalMark < 0 || totalMark > 100) {
            throw new IllegalArgumentException("totalMark must be between 0 and 100");
        }

        this.totalMark = totalMark;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) throws IllegalArgumentException{
        if (GPA == null) {
            throw new IllegalArgumentException("GPA cannot be null");
        }

        if (GPA < 0 || GPA > 4) {
            throw new IllegalArgumentException("GPA must be between 0 and 4");
        }

        this.GPA = GPA;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) throws IllegalArgumentException{
        if (grade == null || grade.isEmpty()) {
            throw new IllegalArgumentException("grade cannot be null or empty");
        }

        if (!grade.matches("^[A-F][+-]?$")) {
            throw new IllegalArgumentException("grade must be in the format of A+, A, A-, B+, B, B-, C+, C, C-, D+, D, F");
        }

        this.grade = grade;
    }
}
