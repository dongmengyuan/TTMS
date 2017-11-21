package main.java.servlet;

import main.se.ttms.idao.DAOFactory;
import main.se.ttms.model.Employee;
import main.se.ttms.model.User;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO:一个账号登陆后，另一个账户登录，会访问前一个账户的内容，所以登陆后需要清除原session
        // request.getSession().setAttribute("login", null);
        // request.getSession().setAttribute("a", null);
        // request.getSession().setAttribute("b", null);
        // request.getSession().invalidate();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String result = "用户名、密码错误";
        String page = "index.jsp";

        User info =  DAOFactory.creatUserDao().findUserByNo(name);

        if(info!=null && info.getEmp_pass().equals(pass)){
            request.getSession().setAttribute("login","ok");
            request.getSession().setAttribute("name","name");
            if(info.getType()==1) {
                page = "studio.jsp";
            }else{
                page = "studio.jsp";
            }
        }else{
            request.setAttribute("result", result);

        }
//        request.getRequestDispatcher(page).forward(request, response);
        response.sendRedirect(page);

    }
}
