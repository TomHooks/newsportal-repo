package by.pvt.maruk.newsportal.commands.impl.author;

import by.pvt.maruk.newsportal.commands.AbstractCommand;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Юра on 07.12.2016.
 */
public class AddNewCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest httpServletRequest) {
        String page = ConfigurationManager.getInstance().getProperty(PagePath.ADDNEW_PAGE_PATH);
        return page;
    }
}
