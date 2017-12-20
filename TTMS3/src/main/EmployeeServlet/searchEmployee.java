package main.EmployeeServlet;

import main.se.ttms.model.Employee;
import main.se.ttms.model.PageBean;
import main.se.ttms.service.EmployeeService;
import main.se.ttms.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SAAJResult;
import java.io.IOException;

@WebServlet("/searchEmployee")
public class searchEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currPage = Integer.parseInt(request.getParameter("currPage"));

        int pageSize = 6;
        String keywords = request.getParameter("keywords");
        System.out.println(keywords);
        EmployeeService employeeService = new EmployeeServiceImpl();

        PageBean<Employee> pageBean = null;
        try {
            pageBean = employeeService.findAllEmployeeByPage(keywords,currPage,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.removeAttribute("pageBean");
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/employee.jsp").forward(request, response);
    }
}
