package by.pvt.maruk.newsportal.commands.impl.guest;

import by.pvt.maruk.newsportal.commands.AbstractCommand;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.constants.Parameters;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yura on 19.11.2016.
 */
public class GoToBack extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest httpServletRequest) {
        String page  = ConfigurationManager.getInstance().getProperty(PagePath.MAIN_PAGE_PATH);
        return page;
    }
}
