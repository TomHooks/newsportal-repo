package by.pvt.maruk.newsportal.commands.impl.guest;

import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.commands.AbstractCommand;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.constants.Parameters;
import by.pvt.maruk.newsportal.dao.UserDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.implementations.UserDAOImpl;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yura on 18.11.2016.
 */
public class RegistrationCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest httpServletRequest) {
        User user = new User();
        user.setUserLogin(httpServletRequest.getParameter("login"));
        user.setUserPassword(httpServletRequest.getParameter("password"));
        user.setUserFirstName(httpServletRequest.getParameter("firstname"));
        user.setUserLastName(httpServletRequest.getParameter("lasttname"));
        user.setUserEmail(httpServletRequest.getParameter("email"));
        UserDAO userDAO = new UserDAOImpl();
        try {
            userDAO.addUser(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }


        String page = ConfigurationManager.getInstance().getProperty(PagePath.MAIN_PAGE_PATH);
        return page ;
    }
}
