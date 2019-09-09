package servlet;

import dao.ManageDao;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/modify")
public class modify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");
        String stdNumber = request.getParameter("stdNumber");
        ManageDao dao = new ManageDao();
        Student student = new Student();
        student.setMajor(major);
        student.setName(name);
        student.setAge(age);
        student.setSex(gender);
        student.setSid(stdNumber);
        dao.updateBySid(student);
        request.getRequestDispatcher("/index2.jsp").forward(request,response);
    }
}
