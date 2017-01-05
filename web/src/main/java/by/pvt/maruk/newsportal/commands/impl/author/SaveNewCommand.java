package by.pvt.maruk.newsportal.commands.impl.author;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.commands.AbstractCommand;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.constants.Parameters;
import by.pvt.maruk.newsportal.dao.NewDAO;


import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.implementations.NewDAOImpl;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by Юра on 16.12.2016.
 */
public class SaveNewCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest httpServletRequest) {
        NewDAO newDAO = new NewDAOImpl();
        User user = null;
        New aNew = null;
        HttpSession session = httpServletRequest.getSession();
        user = (User) session.getAttribute(Parameters.USER);
        aNew.setNewsTitle(httpServletRequest.getParameter(Parameters.TITLE));
        aNew.setNewsContent(httpServletRequest.getParameter(Parameters.CONTENT));
        aNew.setUser(user);
        try {
            newDAO.addNew(aNew);
        } catch (DAOException e) {
            e.printStackTrace();
        }


        String page = ConfigurationManager.getInstance().getProperty(PagePath.USER_PAGE_PATH);
        return page;
    }
}
