package by.pvt.maruk.newsportal;


import by.pvt.maruk.newsportal.Implementations.UserDAOImpl;
import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.dao.UserDAO;

/**
 * Created by yura on 07.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUserLogin("yurikss");
        user.setUserPassword("yurikss123");
        UserDAO userDAO = new UserDAOImpl();
        userDAO.addUser(user);
    }
}