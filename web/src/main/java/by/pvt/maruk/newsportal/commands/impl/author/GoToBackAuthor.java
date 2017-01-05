package by.pvt.maruk.newsportal.commands.impl.author;

import by.pvt.maruk.newsportal.commands.AbstractCommand;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.filter.ClientType;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;
import by.pvt.maruk.newsportal.utils.RequestParameterParser;
import org.hibernate.usertype.UserType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Юра on 16.12.2016.
 */
public class GoToBackAuthor extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest httpServletRequest) {
        String page = null;
        HttpSession session = httpServletRequest.getSession();
        ClientType clientTypeType = RequestParameterParser.getClientType(httpServletRequest);
        if(clientTypeType == ClientType.AUTHOR){
            page = ConfigurationManager.getInstance().getProperty(PagePath.USER_PAGE_PATH);
        }
        else{
            page = ConfigurationManager.getInstance().getProperty(PagePath.MAIN_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}
