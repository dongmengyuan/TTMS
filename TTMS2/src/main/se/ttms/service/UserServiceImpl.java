package main.se.ttms.service;

import main.se.ttms.dao.UserDao;
import main.se.ttms.dao.UserDaoImpl;
import main.se.ttms.model.Employee;
import main.se.ttms.model.User;

import java.util.List;



public class UserServiceImpl implements UserService {

	
	public User findUserByIdAndPass(String id, String pass) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.findUserByIdAndPass(id, pass);
	}

	@Override
	public void updateUserheadpath(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.updateUserheadpath(user);
	}

	@Override
	public List<User> findAll() throws Exception {
		UserDao userDao = new UserDaoImpl();
		
		return userDao.findAll();
	}

	@Override
	public List<Employee> selectEmpno() throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.selectEmpno();
	}

	@Override
	public void addUser(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
	}

	@Override
	public User checkUser(String username) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.checkUser(username);
	}

}
