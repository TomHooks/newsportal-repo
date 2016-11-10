package by.pvt.maruk.newsportal.utils;

import by.pvt.maruk.newsportal.constants.Parameters;
import by.pvt.maruk.newsportal.factory.CommandType;
import by.pvt.maruk.newsportal.filter.ClientType;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yura on 09.11.2016.
 */
public class RequestParameterParser {
    private RequestParameterParser() {
    }

    public static ClientType getClientType(HttpServletRequest httpServletRequest) {
        return (ClientType) httpServletRequest.getSession().getAttribute(Parameters.CLIENT_TYPE);
    }

    public static CommandType getCommandType(HttpServletRequest httpServletRequest) {
        String commandName = httpServletRequest.getParameter(Parameters.COMMAND);
        CommandType commandType = CommandType.LOGIN;
        if (commandName != null) {
            commandType = CommandType.valueOf(commandName.toUpperCase());
        }
        return commandType;
    }

}
