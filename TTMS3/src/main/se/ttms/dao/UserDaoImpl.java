package main.se.ttms.dao;

import java.sql.SQLException;

import java.util.List;

import main.se.ttms.model.Employee;
import main.se.ttms.model.User;
import main.se.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;




public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByIdAndPass(String id, String pass) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where emp_no = ? and emp_pass = ?";
		return queryRunner.query(sql, new BeanHandler<>(User.class),id,pass);
	}

	@Override
	public void updateUserheadpath(User user) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "update user set emp_pass = ?,head_path = ? where emp_no = ?";
		
		queryRunner.update(sql,user.getEmp_pass(),user.getHead_path(),user.getEmp_no());
	}

	@Override
	public List<User> findAll() throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select * from user";
		return queryRunner.query(sql, new BeanListHandler<>(User.class));
	}

	@Override
	public List<Employee> selectEmpno() throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT * FROM employee WHERE emp_no NOT IN (SELECT emp_no FROM user)";
		//ColumnListHandler
		
		
		return queryRunner.query(sql, new BeanListHandler<>(Employee.class));
	}

	@Override
	public void addUser(User user) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "insert into user values(?,?,?,?)";
		
		queryRunner.update(sql,user.getEmp_no(),user.getEmp_pass(),user.getType(),user.getHead_path());
		
	}

	@Override
	public User checkUser(String username) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from user where emp_no = ?";

		return queryRunner.query(sql,new BeanHandler<>(User.class),username);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "delete from user where emp_no = ?";

		qr.update(sql,id);
	}

}
