package main.se.ttms.dao;

import main.se.ttms.model.Employee;

import java.util.List;

public interface EmployeeDao {

	public List<Employee> findAllEmployeeByPage(int currPage, int pageSize) throws Exception;

	public int getTotal() throws Exception;

	public Employee findEmployeeById(String id) throws Exception;

	public void updateEmployee(Employee employee) throws Exception;

	public void deleteEmployee(int eid) throws Exception;

	public Employee findEmployeeByNo(String emp_no) throws Exception;

	public void addEmployee(Employee employee) throws Exception;

	public List<Employee> searchEmployee(String keywords) throws Exception;
}
