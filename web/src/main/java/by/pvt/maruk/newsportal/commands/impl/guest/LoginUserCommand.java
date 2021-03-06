package by.pvt.maruk.newsportal.commands.impl.guest;

import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.commands.AbstractCommand;
import by.pvt.maruk.newsportal.constants.MessageConstants;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.constants.Parameters;
import by.pvt.maruk.newsportal.dao.UserDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.filter.ClientType;
import by.pvt.maruk.newsportal.implementations.UserDAOImpl;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;
import by.pvt.maruk.newsportal.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yura on 10.11.2016.
 */
public class LoginUserCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest httpServletRequest) {
        String page;
        UserDAO userDAO = new UserDAOImpl();
        User user;
        try {
            String login = httpServletRequest.getParameter(Parameters.LOGIN);

            user = userDAO.getUserByLogin(login);
            String guestPassword = httpServletRequest.getParameter(Parameters.PASSWORD);
            String authorPassword = userDAO.getUserPassword(httpServletRequest.getParameter(Parameters.LOGIN));
            if (guestPassword.equals(authorPassword)) {
                page = ConfigurationManager.getInstance().getProperty(PagePath.USER_PAGE_PATH);
                ClientType clientType = ClientType.AUTHOR;
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute(Parameters.CLIENT_TYPE, clientType);
                session.setAttribute(Parameters.USER, user);
                httpServletRequest.setAttribute(Parameters.USER_LOGIN, httpServletRequest.getParameter(Parameters.LOGIN));

            } else {
                page = ConfigurationManager.getInstance().getProperty(PagePath.MAIN_PAGE_PATH);
                httpServletRequest.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
            }


        } catch (DAOException e) {
            page = ConfigurationManager.getInstance().getProperty(PagePath.MAIN_PAGE_PATH);
            httpServletRequest.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }


        return page;
    }
}
