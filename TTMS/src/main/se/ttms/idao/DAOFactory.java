package main.se.ttms.idao;


import main.se.ttms.dao.EmployeeDAO;
import main.se.ttms.dao.UserDao;

public class DAOFactory
{
    public static IEmployee creatEmployeDao()
    {
        return new EmployeeDAO();
    }
    public static IUser creatUserDao()
    {
        return new UserDao();
    }
}
