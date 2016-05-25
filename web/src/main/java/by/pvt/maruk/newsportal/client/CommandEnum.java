package by.pvt.maruk.newsportal.client;

import by.pvt.maruk.newsportal.command.ActionCommand;
import by.pvt.maruk.newsportal.command.LoginCommand;
import by.pvt.maruk.newsportal.command.LogoutCommand;

/**
 * Created by yura on 14.05.2016.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
