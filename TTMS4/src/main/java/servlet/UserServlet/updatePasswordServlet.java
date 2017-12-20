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

@WebServlet("/updatePasswordServlet")
public class updatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("emp_newpass");
        User user = (User) request.getSession().getAttribute("user");

        user.setEmp_pass(parameter);

        UserService service = new UserServiceImpl();

        try {
            service.updateUserheadpath(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
    }
}
