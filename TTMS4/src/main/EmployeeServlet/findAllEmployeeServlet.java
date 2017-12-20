package main.EmployeeServlet;

import com.alibaba.druid.sql.parser.Keywords;
import main.se.ttms.model.Employee;
import main.se.ttms.model.PageBean;
import main.se.ttms.model.User;
import main.se.ttms.service.EmployeeService;
import main.se.ttms.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findAllEmployeeServlet")
public class findAllEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user.getType()==0){
            request.setAttribute("msg", "您无权访问");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        final int pageSize = 6;

        int currPage = Integer.parseInt(request.getParameter("currPage"));
        String username = request.getParameter("keywords");
        System.out.println(username);
        EmployeeService employeeService = new EmployeeServiceImpl();

        try {
            PageBean<Employee> pageBean = employeeService.findAllEmployeeByPage(username,currPage,pageSize);
            System.out.println(pageBean.getTotalPage());
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("keywords", username);
            request.getRequestDispatcher("/employee.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
