package by.pvt.maruk.newsportal.commands.factory;

import by.pvt.maruk.newsportal.commands.ICommand;
import by.pvt.maruk.newsportal.commands.impl.guest.*;

/**
 * Created by yura on 10.11.2016.
 */
public enum CommandType {
    //Guest commands
    LOGIN, REGISTRATION, GOTOREGISTRATION, GOTOBACK, EMPTY;
    public ICommand getCurrentCommand() throws EnumConstantNotPresentException {
        switch (this) {
            case GOTOBACK:
                return new GoToBack();
            case REGISTRATION:
                return new RegistrationCommand();
            case GOTOREGISTRATION:
                return new GoToRegistrationCommand();
            case LOGIN:
                return new LoginUserCommand();
            default:
                return new EmptyCommand();
            //throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name())

        }
    }
}
