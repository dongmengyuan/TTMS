package main.java.servlet.UserServlet;

import com.google.gson.Gson;
import main.se.ttms.model.User;
import main.se.ttms.service.UserService;
import main.se.ttms.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkUserServlet")
public class checkUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        UserService userService = new UserServiceImpl();

        try {
            User user = userService.checkUser(username);
            String msg = "";
            if (user!=null) {
                msg = "用户名正确";
            }else{
                msg="不存在该用户名";
            }
            Gson gson = new Gson();
            String json = gson.toJson(msg);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.append(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
