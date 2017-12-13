package main.se.ttms.service;

import main.se.ttms.model.Employee;
import main.se.ttms.model.User;

import java.util.List;



public interface UserService {
	public User findUserByIdAndPass(String id, String pass) throws Exception;

	public void updateUserheadpath(User user) throws Exception;

	public List<User> findAll() throws Exception;

	public List<Employee> selectEmpno() throws Exception;

	public void addUser(User user) throws Exception;

    public User checkUser(String username) throws Exception;


}
