package Model;

import java.sql.Date;

public class Instructors {

    int InstructorID;
    String InstructorName;
    Date BirthDate;
    String Gender;
    int SubjectID;

    public Instructors() {
    }

    public Instructors(int InstructorID, String InstructorName, Date BirthDate, String Gender, int SubjectID) {
        this.InstructorID = InstructorID;
        this.InstructorName = InstructorName;
        this.BirthDate = BirthDate;
        this.Gender = Gender;
        this.SubjectID = SubjectID;
    }

    public int getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(int InstructorID) {
        this.InstructorID = InstructorID;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public void setInstructorName(String InstructorName) {
        this.InstructorName = InstructorName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    @Override
    public String toString() {
        return "Instructors{" + "InstructorID=" + InstructorID + ", InstructorName=" + InstructorName + ", BirthDate=" + BirthDate + ", Gender=" + Gender + ", SubjectID=" + SubjectID + '}';
    }

}
