package servlet;

import dao.LoginDao;
import entity.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Manager manager = new Manager();
        manager.setUsername(request.getParameter("uuid"));
        manager.setPassword(request.getParameter("passwd"));

        LoginDao dao = new LoginDao();
        Manager login = dao.login(manager);
        if(login==null){
            //登陆失败
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名或者密码错误");
        }else{
            //登陆成功
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
