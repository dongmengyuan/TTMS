package main.se.ttms.dao;

import java.util.ArrayList;
import java.util.List;

import main.se.ttms.model.Employee;
import main.se.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> findAllEmployeeByPage(String keywrods,int currPage, int pageSize) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		int param1 = (currPage-1)*pageSize;
		String sql = "select * from employee ";
		if(keywrods!=null&&!keywrods.equals("")){
			ArrayList<String> param = new ArrayList<>();
			param.add("%"+keywrods+"%");
			sql+="where emp_name like ? ";
			sql+="limit "+param1+","+pageSize;
			return queryRunner.query(sql, new BeanListHandler<>(Employee.class),param.toArray());
		}
		sql+="limit ?,?";
		return queryRunner.query(sql, new BeanListHandler<>(Employee.class), (currPage-1)*pageSize,pageSize);
	}

	@Override
	public int getTotal(String keywords) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from employee ";
		if (keywords!=null&&!"".equals(keywords)){
			ArrayList<String> params = new ArrayList<>();
			params.add("%"+keywords+"%");
			sql+="where emp_name like ?";
			return ((Long)queryRunner.query(sql, new ScalarHandler(),params.toArray())).intValue();
		}

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
	public List<Employee> searchEmployee(String keywords, int currPage, int pageSize) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		int param1 = (currPage-1)*pageSize;
		ArrayList<String> params = new ArrayList<>();
		String sql = "select * from employee where emp_name like ? order by emp_id limit "+param1+","+pageSize;
		params.add("%"+keywords+"%");
		return queryRunner.query(sql,new BeanListHandler<>(Employee.class),params.toArray());
	}

	@Override
	public int getsearchTotal(String keywords) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		ArrayList<String> params = new ArrayList<>();
		params.add("%"+keywords+"%");
		String sql = "select count(*) from employee where emp_name like ?";
		return ((Long)queryRunner.query(sql, new ScalarHandler(),params.toArray())).intValue();
	}

}
