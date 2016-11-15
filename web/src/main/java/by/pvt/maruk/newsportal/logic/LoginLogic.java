package by.pvt.maruk.newsportal.logic;


import by.pvt.maruk.newsportal.dao.NewDAO;
import by.pvt.maruk.newsportal.dao.UserDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.implementations.NewDAOImpl;
import by.pvt.maruk.newsportal.implementations.UserDAOImpl;

/**
 * Created by yura on 14.05.2016.
 */
public class LoginLogic {
    private final static String ADMIN_LOGIN = "moderator";
    private final static String ADMIN_PASS = "123";






    public static boolean checkAdminLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
    }

    public static boolean checkUserLogin(String enterLogin, String enterPass) {
        UserDAO userDAO = new UserDAOImpl();
        String userPassword = null;
        try {
           userPassword = userDAO.getUserPassword(enterLogin);

        } catch (DAOException e) {
            e.printStackTrace();
        }

        return enterPass.equals(userPassword);
    }
}
