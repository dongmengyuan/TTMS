package main.EmployeeServlet;

import main.se.ttms.model.Employee;
import main.se.ttms.model.PageBean;
import main.se.ttms.service.EmployeeService;
import main.se.ttms.service.EmployeeServiceImpl;
import main.se.ttms.service.UserService;
import main.se.ttms.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dongmengyuan on 17-12-13.
 */

@WebServlet("/searchEmployeeServlet")
public class searchEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keywords = request.getParameter("keywords");
        //String param = "'%"+keywords+"%'";
        //System.out.println(param);
        EmployeeService service = new EmployeeServiceImpl();

        try {
            List<Employee> employees = service.searchEmployee(keywords);

            PageBean<Employee> pageBean = new PageBean<Employee>();

            pageBean.setList(employees);

            request.setAttribute("pageBean",pageBean);

            request.getRequestDispatcher("/employee.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
