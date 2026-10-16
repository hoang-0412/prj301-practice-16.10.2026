package dal;

import java.util.Vector;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Model.Students;
import Model.Subjects;
import java.sql.SQLException;

public class StudentDAO extends DBContext {

    public Vector<Subjects> getAllSubjects() {
        Vector<Subjects> vector = new Vector<>();
        String sql = "select * from Subjects";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Subjects s = new Subjects(rs.getInt(1), rs.getString(2));
                vector.add(s);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return vector;
    }

    public Vector<Students> getAllStudents() {
        Vector<Students> vector = new Vector<>();
        String sql = "select * from Students";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Students s = new Students(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5));
                vector.add(s);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return vector;
    }

    public int insertStudent(Students s) {
        String sql = "INSERT INTO [dbo].[Students]\n"
                + "           ([StudentID]\n"
                + "           ,[StudentName]\n"
                + "           ,[BirthDate]\n"
                + "           ,[Gender]\n"
                + "           ,[SubjectID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int n = 0;
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, s.getStudentID());
            ptm.setString(2, s.getStudentName());
            ptm.setDate(3, s.getBirthDate());
            ptm.setString(4, s.getGender());
            ptm.setInt(5, s.getSubjectID());
            n = ptm.executeUpdate();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return n;
    }
}
