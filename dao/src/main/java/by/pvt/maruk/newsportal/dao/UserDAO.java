package by.pvt.maruk.newsportal.dao;

import by.pvt.maruk.beans.User;

/**
 * Created by yura on 07.06.2016.
 */
public interface UserDAO {

    void addUser(User user);
    User getUserPassword(String userLogin);
}
