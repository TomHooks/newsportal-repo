package by.pvt.maruk.newsportal.commands.factory;

import by.pvt.maruk.newsportal.commands.ICommand;
import by.pvt.maruk.newsportal.commands.impl.guest.LoginUserCommand;
import by.pvt.maruk.newsportal.utils.RequestParameterParser;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yura on 10.11.2016.
 */
public class CommandFactory {
    private static CommandFactory instance;
    private CommandFactory(){}
    public static synchronized CommandFactory getInstance(){
        if(instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }

    public ICommand defineCommand(HttpServletRequest httpServletRequest){
        ICommand current = null;
        try{
            CommandType type = RequestParameterParser.getCommandType(httpServletRequest);
            current = type.getCurrentCommand();
        }
        catch(IllegalArgumentException e){
            current = new LoginUserCommand();
        }
        return current;
    }
}
