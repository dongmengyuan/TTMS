package main.se.ttms.dao;

import java.util.List;

import main.se.ttms.model.Employee;
import main.se.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> findAllEmployeeByPage(int currPage, int pageSize) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select * from employee order by emp_id limit ?,?";
		
		return queryRunner.query(sql, new BeanListHandler<>(Employee.class), (currPage-1)*pageSize,pageSize);
	}

	@Override
	public int getTotal() throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select count(*) from employee";
		return ((Long)queryRunner.query(sql, new ScalarHandler())).intValue();
	}

	@Override
	public Employee findEmployeeById(String id) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select * from employee where emp_id = ?";
		return queryRunner.query(sql, new BeanHandler<>(Employee.class),id);
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "update employee set emp_no = ?,emp_name = ?,emp_tel_num = ?,emp_addr = ? where emp_id = ?";
		
		queryRunner.update(sql, employee.getEmp_no(),employee.getEmp_name(),employee.getEmp_tel_num(),
				employee.getEmp_addr(),employee.getEmp_id());
	}

	@Override
	public void deleteEmployee(int eid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from employee where emp_id = ?";
		queryRunner.update(sql,eid);
	}

	@Override
	public Employee findEmployeeByNo(String emp_no) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from employee where emp_no = ?";
		return queryRunner.query(sql, new BeanHandler<>(Employee.class),emp_no);
	}

	@Override
	public void addEmployee(Employee employee) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "insert into employee(emp_no,emp_name,emp_tel_num,emp_addr,emp_email) values(?,?,?,?,?)";

		queryRunner.update(sql,employee.getEmp_no(),employee.getEmp_name(),employee.getEmp_tel_num(),employee.getEmp_addr(),employee.getEmp_email());
	}

	@Override
	public List<Employee> searchEmployee(String keywords) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from employee where emp_name like ?";
		//String param = "'%"+keywords+"%'";
		return qr.query(sql,new BeanListHandler<>(Employee.class),"'%"+keywords+"%'");
	}

}
