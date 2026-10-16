package Model;

import java.sql.Date;

public class Students {

    String StudentID, StudentName;
    Date BirthDate;
    String Gender;
    int SubjectID;

    public Students() {
    }

    public Students(String StudentID, String StudentName, Date BirthDate, String Gender, int SubjectID) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.BirthDate = BirthDate;
        this.Gender = Gender;
        this.SubjectID = SubjectID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
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
        return "Students{" + "StudentID=" + StudentID + ", StudentName=" + StudentName + ", BirthDate=" + BirthDate + ", Gender=" + Gender + ", SubjectID=" + SubjectID + '}';
    }

}
