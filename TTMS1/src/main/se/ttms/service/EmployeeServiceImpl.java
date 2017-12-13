package main.se.ttms.service;

import main.se.ttms.dao.EmployeeDao;
import main.se.ttms.dao.EmployeeDaoImpl;
import main.se.ttms.model.Employee;
import main.se.ttms.model.PageBean;

import java.util.List;



public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public PageBean<Employee> findAllEmployeeByPage(int currPage, int pageSize) throws Exception {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		List<Employee> list = employeeDao.findAllEmployeeByPage(currPage,pageSize);
		
		int totalCount = employeeDao.getTotal();
		
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}

	@Override
	public Employee findEmployeeById(String id) throws Exception {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.findEmployeeById(id);
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.updateEmployee(employee);
	}

	

	@Override
	public void deleteEmployee(int eid) throws Exception {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.deleteEmployee(eid);
	}

	@Override
	public Employee findEmployeeByNo(String emp_no) throws Exception {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.findEmployeeByNo(emp_no);
	}

	@Override
	public void addEmployee(Employee employee) throws Exception {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.addEmployee(employee);
	}

	@Override
	public List<Employee> searchEmployee(String keywords) throws Exception {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.searchEmployee(keywords);
	}

}
