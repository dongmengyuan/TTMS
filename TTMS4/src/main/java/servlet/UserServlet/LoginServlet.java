package main.java.servlet.UserServlet;

import main.se.ttms.model.User;
import main.se.ttms.service.UserService;
import main.se.ttms.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        UserService service = new UserServiceImpl();
        User user = null;
        try {
            user = service.findUserByIdAndPass(name, pass);
            if(user==null){
                request.setAttribute("msg", "用户名密码错误");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/employee.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
