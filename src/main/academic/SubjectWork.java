package main.academic;

public class SubjectWork {
    private String subjectCode;
    private int activitiesMark;
    private int practicalMark;
    private int midtermMark;
    private int finalMark;

    public SubjectWork(){

    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getActivitiesMark() {
        return activitiesMark;
    }

    public void setActivitiesMark(int activitiesMark) {
        this.activitiesMark = activitiesMark;
    }

    public int getPracticalMark() {
        return practicalMark;
    }

    public void setPracticalMark(int practicalMark) {
        this.practicalMark = practicalMark;
    }

    public int getMidtermMark() {
        return midtermMark;
    }

    public void setMidtermMark(int midtermMark) {
        this.midtermMark = midtermMark;
    }

    public int getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }
}
