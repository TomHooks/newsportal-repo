package by.pvt.maruk.newsportal;


import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.implementations.UserDAOImpl;
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
        user.setUserFirstName("Юра1");
        user.setUserLastName("Марук");
        user.setUserEmail("yurikss2005@gmail.com");
        UserDAO userDAO = new UserDAOImpl();
        try {
            userDAO.addUser(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
