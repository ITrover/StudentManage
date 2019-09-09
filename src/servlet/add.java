package servlet;

import dao.ManageDao;
import entity.Manager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/add")
public class add extends HttpServlet {
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
        dao.addStudent(student);
        if(true){
            //添加成功，留在原来页面
        }else{
            //添加失败，显示信息
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
