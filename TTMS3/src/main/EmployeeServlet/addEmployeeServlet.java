package main.EmployeeServlet;

import main.se.ttms.model.Employee;
import main.se.ttms.service.EmployeeService;
import main.se.ttms.service.EmployeeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addEmployeeServlet")
public class addEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        EmployeeService employeeService = new EmployeeServiceImpl();
        try {
            BeanUtils.populate(employee, request.getParameterMap());

            employeeService.addEmployee(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
