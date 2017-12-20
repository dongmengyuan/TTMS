package main.se.ttms.service;


import main.se.ttms.model.Employee;
import main.se.ttms.model.PageBean;

public interface EmployeeService {

	public PageBean<Employee> findAllEmployeeByPage(String keywords,int currPage, int pageSize) throws Exception;

	public Employee findEmployeeById(String id) throws Exception;

	public void updateEmployee(Employee employee) throws Exception;
	
	public void deleteEmployee(int eid) throws Exception;

	public Employee findEmployeeByNo(String emp_no) throws Exception;


	public void addEmployee(Employee employee) throws Exception;

	public PageBean<Employee> searchEmployee(String keywords, int currPage, int pageSize);
}
