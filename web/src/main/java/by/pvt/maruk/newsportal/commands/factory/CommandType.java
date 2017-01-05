package by.pvt.maruk.newsportal.commands.factory;

import by.pvt.maruk.newsportal.commands.ICommand;
import by.pvt.maruk.newsportal.commands.impl.author.AddNewCommand;
import by.pvt.maruk.newsportal.commands.impl.author.GoToBackAuthor;
import by.pvt.maruk.newsportal.commands.impl.author.SaveNewCommand;
import by.pvt.maruk.newsportal.commands.impl.guest.*;

/**
 * Created by yura on 10.11.2016.
 */
public enum CommandType {
    //Guest commands
    LOGIN, LOGOUT, REGISTRATION, GOTOREGISTRATION, GOTOBACK, GOTOHOWGUEST, EMPTY,
    //Author commands
    ADDNEWCOMMAND, GOTOBACKAUTHOR, SAVENEWCOMMAND;

    public ICommand getCurrentCommand() throws EnumConstantNotPresentException {
        switch (this) {
            case GOTOBACK:
                return new GoToBack();
            case ADDNEWCOMMAND:
                return new AddNewCommand();
            case SAVENEWCOMMAND:
                return new SaveNewCommand();
            case GOTOBACKAUTHOR:
                return new GoToBackAuthor();
            case REGISTRATION:
                return new RegistrationCommand();
            case LOGOUT:
                return new LogOutCommand();
            case GOTOREGISTRATION:
                return new GoToRegistrationCommand();
            case LOGIN:
                return new LoginUserCommand();
            case GOTOHOWGUEST:
                return new GoToHowGuest();
            default:
                return new EmptyCommand();
            //throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name())

        }
    }
}
