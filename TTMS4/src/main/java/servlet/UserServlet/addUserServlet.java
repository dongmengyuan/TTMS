package main.java.servlet.UserServlet;

import main.se.ttms.model.User;
import main.se.ttms.service.UserService;
import main.se.ttms.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        try {
            BeanUtils.populate(user, request.getParameterMap());
            String password = "123456";
            user.setEmp_pass(password);
            password = "images/4069fa88fdb21ace!400x400_big.jpg";
            user.setHead_path(password);
            UserService service = new UserServiceImpl();
            service.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
