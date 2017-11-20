package main.se.ttms.idao;


import main.se.ttms.dao.UserDao;

public class DAOFactory
{
    public static IUser creatUserDao()
    {
        return new UserDao();
    }
}
