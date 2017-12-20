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
import java.util.List;

@WebServlet("/findUserAllServlet")
public class findUserAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user.getType()==0){
            request.setAttribute("msg", "您无权访问");
            request.getRequestDispatcher("/error1.jsp").forward(request, response);
        }
        UserService service = new UserServiceImpl();

        try {
            List<User> list = service.findAll();
            System.out.println(list.size());
            request.setAttribute("list", list);

            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
