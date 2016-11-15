package by.pvt.maruk.newsportal.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yura on 10.11.2016.
 */
public interface ICommand {
    String execute(HttpServletRequest httpServletRequest);
}
