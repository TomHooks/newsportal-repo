package by.pvt.maruk.newsportal.commands.factory;

import by.pvt.maruk.newsportal.commands.ICommand;
import by.pvt.maruk.newsportal.commands.impl.guest.GoToRegistrationCommand;
import by.pvt.maruk.newsportal.commands.impl.guest.LoginUserCommand;

/**
 * Created by yura on 10.11.2016.
 */
public enum CommandType {
    LOGIN, GOTOREGISTRATION;

    public ICommand getCurrentCommand() throws EnumConstantNotPresentException {
        switch (this) {
            case GOTOREGISTRATION:
                return new GoToRegistrationCommand();
            default:
                return new LoginUserCommand();
            //throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name())

        }
    }
}
