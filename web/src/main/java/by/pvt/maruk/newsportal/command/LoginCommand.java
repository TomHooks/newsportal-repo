package by.pvt.maruk.newsportal.command;

import by.pvt.maruk.newsportal.filter.ClientType;
import by.pvt.maruk.newsportal.logic.LoginLogic;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;
import by.pvt.maruk.newsportal.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yura on 14.05.2016.
 */
public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        if (LoginLogic.checkAdminLogin(login, pass)) {
            request.setAttribute("user", login);
            HttpSession session = request.getSession(true);
            session.setAttribute("userType", ClientType.ADMINISTRATOR);

            page = ConfigurationManager.getProperty("path.page.main");
        } /*else if (LoginLogic.checkUserLogin(login, pass)) {
            request.setAttribute("user", login);
            HttpSession session = request.getSession(true);
            session.setAttribute("userType", ClientType.USER);
            page = ConfigurationManager.getProperty("path.page.user");
        }*/ else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            request.getSession().setAttribute("userType", ClientType.GUEST);
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
