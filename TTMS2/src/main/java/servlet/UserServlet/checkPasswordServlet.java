package main.java.servlet.UserServlet;

import com.google.gson.Gson;
import main.se.ttms.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkPasswordServlet")
public class checkPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        User user = (User) request.getSession().getAttribute("user");
        String msg = null;
        if(!"".equals(password)){
            if(password.equals(user.getEmp_pass())){
                msg = "密码正确请输入新密码";
            }else{
                msg = "密码错误请重新输入密码";
            }
        }else{
            msg="";
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String json = new Gson().toJson(msg);
        PrintWriter writer = response.getWriter();
        writer.append(json);
    }
}
