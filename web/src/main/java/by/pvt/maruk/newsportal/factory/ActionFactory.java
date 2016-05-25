package by.pvt.maruk.newsportal.factory;

import by.pvt.maruk.newsportal.client.CommandEnum;
import by.pvt.maruk.newsportal.command.ActionCommand;
import by.pvt.maruk.newsportal.command.EmptyCommand;
import by.pvt.maruk.newsportal.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yura on 13.05.2016.
 */
public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());

            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;

    }
}
