package main.EmployeeServlet;

import com.google.gson.Gson;
import main.se.ttms.model.Employee;
import main.se.ttms.service.EmployeeService;
import main.se.ttms.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editEmployeeServlet")
public class editEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        EmployeeService employeeService = new EmployeeServiceImpl();

        try {
            Employee employee = employeeService.findEmployeeById(id);
            Gson gson = new Gson();
            String json = gson.toJson(employee);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.append(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
