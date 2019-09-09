package servlet;

import dao.ManageDao;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet( "/search")
public class search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String serNmae=request.getParameter("name");
        String serSid = request.getParameter("stdNumber");
        System.out.println("on Search");
        System.out.println(serNmae);
        System.out.println(serSid);
        ArrayList<Student> list = null;
        ManageDao dao = new ManageDao();
        if(!serNmae.isEmpty() && !serSid.isEmpty()){
            list=dao.findAllByNameAndSid(serNmae,serSid);
        }else if(!serNmae .isEmpty()){
            list=dao.findAllByName(serNmae);
        }else  if(!serSid.isEmpty()){
            list = dao.findAllBySid(serSid);
        }else {
            System.out.println("空查询");
        }
        System.out.println(list);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/index3.jsp").forward(request,response);
    }
}
