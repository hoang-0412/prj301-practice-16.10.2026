package Model;

public class Subjects {

    int SubjectID;
    String SubjectName;

    public Subjects() {
    }

    public Subjects(int SubjectID, String SubjectName) {
        this.SubjectID = SubjectID;
        this.SubjectName = SubjectName;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    @Override
    public String toString() {
        return "Subjects{" + "SubjectID=" + SubjectID + ", SubjectName=" + SubjectName + '}';
    }

}
