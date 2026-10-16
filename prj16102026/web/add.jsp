<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector, Model.Students, Model.Subjects"%>
<!DOCTYPE html>
<html>
    <%
        Vector<Subjects> listSubject = (Vector<Subjects>) request.getAttribute("listSubject");
        Vector<Students> listStudent = (Vector<Students>) request.getAttribute("listStudent");
        Vector<String> listSubjectName = (Vector<String>) request.getAttribute("listSubjectName");
        if (listStudent == null) {
            response.sendRedirect("add");
            return;
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Students Page</title>
    </head>
    <body>
        <p>List of Students:</p>
        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Subject</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (listStudent != null) {
                        for (int i = 0; i < listStudent.size(); i++) {
                            Students s = listStudent.get(i);
                            String subjectName = (listSubjectName != null && i < listSubjectName.size())
                                    ? listSubjectName.get(i) : "";
                %>
                <tr>
                    <td><%=s.getStudentID()%></td>
                    <td><%=s.getStudentName()%></td>
                    <td><%=s.getBirthDate()%></td>
                    <td><%=s.getGender()%></td>
                    <td><%=subjectName%></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <p>Detail information:</p>
        <form action="add" method="POST">
            <table>
                <tr>
                    <td>Code:</td>
                    <td><input type="text" name="code"></td>
                    <td>Name:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Date of birth:</td>
                    <td><input type="text" name="dob"></td>
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="gender" value="Male"> Male
                        <input type="radio" name="gender" value="Female" checked> Female
                    </td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td>
                        <select name="subjectId">
                            <%
                                if (listSubject != null) {
                                    for (Subjects sub : listSubject) {
                            %>
                            <option value="<%=sub.getSubjectID()%>"><%=sub.getSubjectName()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </td>
                    <td>
                        <input type="submit" name="submit" value="CREATE">
                        <input type="hidden" name="service" value="addStudent">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>