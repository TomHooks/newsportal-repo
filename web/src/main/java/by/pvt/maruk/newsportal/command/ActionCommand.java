package by.pvt.maruk.newsportal.command;

import by.pvt.maruk.newsportal.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yura on 13.05.2016.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);

}
