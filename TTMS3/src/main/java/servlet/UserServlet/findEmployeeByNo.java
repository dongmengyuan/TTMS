package main.java.servlet.UserServlet;

import main.se.ttms.model.Employee;
import main.se.ttms.service.EmployeeService;
import main.se.ttms.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findEmployeeByNo")
public class findEmployeeByNo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_no = request.getParameter("emp_no");

        EmployeeService employeeService = new EmployeeServiceImpl();

        try {
            Employee employee = employeeService.findEmployeeByNo(emp_no);

            request.getSession().setAttribute("employee", employee);

            request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
