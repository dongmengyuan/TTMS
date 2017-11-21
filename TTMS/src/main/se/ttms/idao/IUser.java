package main.se.ttms.idao;

import main.se.ttms.model.User;

/**
 * Created by dongmengyuan on 17-11-19.
 */

public interface IUser
{
    // 增
    public boolean insert(User user);

    // 删
    public boolean delete(int emp_no);

    // 改
    public boolean update(User user);

//    // 查所有用户(一般用于和界面交互)
//    public ArrayList<Employee> findEmployeeAll();

    // 根据用户名查(一般用于和界面交互)
    public User findUserByNo(String employeeName);
//
//    // 根据用户id查(一般用于数据内部关联操作)
//    public Employee findEmployeeById(int employeeId);
}
