package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import java.sql.Date;
import dal.StudentDAO;
import Model.Students;
import Model.Subjects;

@WebServlet(name = "AddStudentServlet", urlPatterns = {"/add"})
public class AddStudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        StudentDAO dao = new StudentDAO();

        String service = request.getParameter("service");
        if (service == null) {
            service = "addStudent";
        }

        if (service.equals("addStudent")) {
            String submit = request.getParameter("submit");

            if (submit == null && !"POST".equalsIgnoreCase(request.getMethod())) {
                Vector<Subjects> listSubject = dao.getAllSubjects();
                Vector<Students> listStudent = dao.getAllStudents();

                Vector<String> listSubjectName = new Vector<>();
                if (listStudent != null && listSubject != null) {
                    for (Students s : listStudent) {
                        String subName = "";
                        for (Subjects sub : listSubject) {
                            if (sub.getSubjectID() == s.getSubjectID()) {
                                subName = sub.getSubjectName();
                                break;
                            }
                        }
                        listSubjectName.add(subName);
                    }
                }

                request.setAttribute("listSubject", listSubject);
                request.setAttribute("listStudent", listStudent);
                request.setAttribute("listSubjectName", listSubjectName);

                request.getRequestDispatcher("add.jsp").forward(request, response);
            } else {
                String code = request.getParameter("code");
                String name = request.getParameter("name");
                String dobRaw = request.getParameter("dob");
                String gender = request.getParameter("gender");
                String subjectIdRaw = request.getParameter("subjectId");

                try {
                    Date dob = Date.valueOf(dobRaw);
                    int subjectId = Integer.parseInt(subjectIdRaw);

                    Students s = new Students(code, name, dob, gender, subjectId);
                    dao.insertStudent(s);
                } catch (NumberFormatException ex) {
                    ex.getStackTrace();
                }

                response.sendRedirect("add");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "AddStudentServlet";
    }// </editor-fold>
}
