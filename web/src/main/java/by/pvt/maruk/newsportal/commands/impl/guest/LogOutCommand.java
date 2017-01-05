package by.pvt.maruk.newsportal.commands.impl.guest;

import by.pvt.maruk.newsportal.commands.AbstractCommand;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Юра on 06.12.2016.
 */
public class LogOutCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest httpServletRequest) {

        String page = ConfigurationManager.getInstance().getProperty(PagePath.INDEX_PAGE_PATH);
        httpServletRequest.getSession().invalidate();
        return page;
    }
}
