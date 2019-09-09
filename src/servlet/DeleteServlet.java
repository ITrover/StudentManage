package servlet;

import dao.ManageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid=request.getParameter("stdNumber");
        if(sid == null){
            //提交为空，不予处理
        }else {
            ManageDao dao = new ManageDao();
            dao.deleteBySid(sid);
            //显示删除成功,留在本页面
        }
        request.getRequestDispatcher("/index1.jsp").forward(request,response);
    }
}
