package main.se.ttms.dao;

import main.se.ttms.idao.IUser;

import main.se.ttms.model.User;
import main.se.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by dongmengyuan on 17-11-19.
 */

public class UserDao implements IUser
{
    /**
     * 存储用户信息
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean insert(User user)
    {
        boolean result = false;
        if(user == null)
            return result;

        // 获取Connection
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            String sql = "insert into Employee(emp_no, emp_pass, type, head_path) values(?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmp_no());
            pstmt.setString(2, user.getEmp_pass());
            pstmt.setInt(3, user.getType());
            pstmt.setString(4, user.getHead_path());


            pstmt.executeUpdate();
            result = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }

    /**
     * 删除用户(通过employeeId)
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean delete(int emp_no)
    {
        boolean result = false;
        if(emp_no == 0)
            return result;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            // 删除子某个用户
            String sql = "delete from user where emp_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, emp_no);
            pstmt.executeUpdate();
            ConnectionManager.close(null, pstmt, con);

            result = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }

    /**
     * 修改用户信息
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean update(User user)
    {
        boolean result = false;
        if(user == null)
            return result;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            String sql = "update employee set emp_no=?,emp_pass?,type=?,head_path=? where emp_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmp_no());
            pstmt.setString(2, user.getEmp_pass());
            pstmt.setInt(3, user.getType());
            pstmt.setString(4, user.getHead_path());

            pstmt.executeUpdate();
            result = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }


//    /**
//     * 获取所有用户信息(一般用于和界面交互)
//     * @return Employee列表
//     */
//    @SuppressWarnings("finally")
//    public ArrayList<User> findEmployeeAll()
//    {
//        ArrayList<Employee> list = new ArrayList<Employee>();
//        Employee info = null;
//
//        Connection con = ConnectionManager.getInstance().getConnection();
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try
//        {
//            // 获取所有用户数据
//            pstmt = con.prepareStatement("select * from employee");
//            rs = pstmt.executeQuery();
//            while(rs.next())
//            {
//                info = new Employee();
//
//                info.setEmp_id(rs.getInt("emp_id"));
//                info.setEmp_no(rs.getString("emp_no"));
//                info.setEmp_name(rs.getString("emp_name"));
//                info.setEmp_tel_num(rs.getString("emp_tel_num"));
//                info.setEmp_addr(rs.getString("emp_addr"));
//                info.setEmp_email(rs.getString("emp_email"));
//                // 加入列表
//                list.add(info);
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            ConnectionManager.close(rs, pstmt, con);
//            return list;
//        }
//    }
//
    /**
     * 根据用户名获取用户信息(一般用于和界面交互)
     * @return Employee列表
     */
    @SuppressWarnings("finally")
    public User findUserByNo(String name)
    {
        if(name == null || name.equals(""))
            return null;

        User info = null;
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据:模糊查询
            pstmt = con.prepareStatement("select * from user where emp_no= ?");
            pstmt.setString(1, name);// 拼接模糊查询串
            rs = pstmt.executeQuery();

            if(rs.next())
            {
                info = new User();
                info.setEmp_no(rs.getString("emp_no"));
                info.setEmp_pass(rs.getString("emp_pass"));
                info.setType(rs.getInt("type"));
                info.setHead_path(rs.getString("head_path"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return info;
        }
    }
//
//    /**
//     * 根据employee_id获取用户信息(一般用于数据内部关联操作)
//     * @return 用户
//     */
//    @SuppressWarnings("finally")
//    public  findEmployeeById(int employeeId)
//    {
//        Employee info = null;
//        if(employeeId == 0)
//            return info;
//
//        Connection con = ConnectionManager.getInstance().getConnection();
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try
//        {
//            // 获取所有用户数据
//            pstmt = con.prepareStatement("select * from employee where emp_id=?");
//            pstmt.setInt(1, employeeId);
//            rs = pstmt.executeQuery();
//            if(rs.next())
//            {
//                // 如果有值的话再实例化
//                info = new Employee();
//                info.setEmp_id(employeeId);
//                info.setEmp_no(rs.getString("emp_no"));
//                info.setEmp_name(rs.getString("emp_name"));
//                info.setEmp_tel_num(rs.getString("emp_tel_num"));
//                info.setEmp_addr(rs.getString("emp_addr"));
//                info.setEmp_email(rs.getString("emp_email"));
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            ConnectionManager.close(rs, pstmt, con);
//            return info;
//        }
//    }
}

